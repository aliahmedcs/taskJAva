package com.yeshtery.picturePublishingService.auth;

import java.net.URI;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.yeshtery.picturePublishingService.model.Picture;
import com.yeshtery.picturePublishingService.model.User;
import com.yeshtery.picturePublishingService.repository.PictureRepository;
import com.yeshtery.picturePublishingService.response.UnProcessedPicturesResponse;
import com.yeshtery.picturePublishingService.repository.CreatedUserRepository;

@RestController
@RequestMapping("/api/any")
public class AuthApi {
	@Autowired
	AuthenticationManager authManager;
	@Autowired
	JwtTokenUtil jwtUtil;
	@Autowired
	private CreatedUserRepository repo;
	@Autowired
	private PictureRepository pictureRepository;

	@PostMapping("/register")

	public ResponseEntity<?> register(@RequestBody @Valid AuthRequest request) {
		try {
			int strength = 10; // work factor of bcrypt
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
			String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
			User user = new User();
			user.setUserName(request.getUserName());
			user.setAddress(request.getAddress());
			user.setEmail(request.getEmail());
			user.setPassword(encodedPassword);

			User savedUser = repo.save(user);
			URI pictureURI = URI.create("/auth/register/" + savedUser.getId());
			return ResponseEntity.created(pictureURI).body(savedUser);
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		catch (Exception e) {
			Map<Integer, String> map = new HashMap();
			map.put(200, "user name already registered");
			return ResponseEntity.ok(map);
		}

	}

	@PostMapping("/login")

	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			// } catch (BadCredentialsException ex) {
//            
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@PostMapping("/all")
	public ResponseEntity<UnProcessedPicturesResponse> acceptedPictures() {
		try {
			UnProcessedPicturesResponse acceptedPictures = new UnProcessedPicturesResponse(200,
					pictureRepository.acceptedPictures());
			return ResponseEntity.ok(acceptedPictures);
		} catch (Exception e) {
			UnProcessedPicturesResponse acceptedPictures = new UnProcessedPicturesResponse(204, e.getMessage());
			return ResponseEntity.ok(acceptedPictures);
		}

	}

}
