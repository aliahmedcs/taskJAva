package com.yeshtery.picturePublishingService.controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
//import com.techgeeknext.entities.Image;
//import com.techgeeknext.repositories.ImageRepository;
//import com.techgeeknext.util.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yeshtery.picturePublishingService.image.ImageUtility;
import com.yeshtery.picturePublishingService.image.UploadPictureRequest;
import com.yeshtery.picturePublishingService.response.GetPictureDetailsResponse;
import com.yeshtery.picturePublishingService.response.UnProcessedPicturesResponse;
import com.yeshtery.picturePublishingService.response.UploadPictureResponse;
import com.yeshtery.picturePublishingService.model.Category;
import com.yeshtery.picturePublishingService.model.Picture;
import com.yeshtery.picturePublishingService.repository.PictureRepository;
import com.yeshtery.picturePublishingService.repository.CreatedUserRepository;

@RestController

@RequestMapping("/api/auth")
public class PictureApi {

	private static String UPLOADED_FOLDER = "/home/ali/uploadedPicture";

	@Autowired
	PictureRepository pictureRepository;

	@PostMapping("/uploadImage")
	@RolesAllowed({ "ROLE_ADMIN", "ROLE_USER", "ROLE_ADMINSTRATIVEUSER" })
	public ResponseEntity<UploadPictureResponse> uplaodImage(
			@ModelAttribute @Valid UploadPictureRequest uploadPictureRequest) throws IOException {
		if (uploadPictureRequest.getImage() == null) {
			return ResponseEntity.ok(new UploadPictureResponse(206, "you don't enter image"));

		}
		List<String> extensions = Arrays.asList("jpg", "png", "gif");
		Picture picture = new Picture();
		String extension = uploadPictureRequest.getImage().getOriginalFilename()
				.substring(uploadPictureRequest.getImage().getOriginalFilename().lastIndexOf(".") + 1);
		if (!extensions.contains(extension)) {
			return ResponseEntity.ok(new UploadPictureResponse(203, "only jpg,png and gif are accepted"));
		}
		if (uploadPictureRequest.getImage().getSize() > 2048000) {
			return ResponseEntity
					.ok(new UploadPictureResponse(202, "image size must not be greater than 2 mega bytes"));
		}
		if (uploadPictureRequest.getCategory() == null) {
			return ResponseEntity.ok(new UploadPictureResponse(204, "you dont enter category"));
		}
		picture.setCategory(uploadPictureRequest.getCategory());

		picture.setDescription(uploadPictureRequest.getDescription());
		byte[] bytes = ImageUtility.compressImage(uploadPictureRequest.getImage().getBytes());
		Path path = Paths.get(
				UPLOADED_FOLDER + new Date().getTime() + "A-A" + uploadPictureRequest.getImage().getOriginalFilename());
		String url = Files.write(path, bytes).toUri().getPath();
		picture.setUrl(url);
//picture.setUrl(ImageUtility.compressImage(uploadPictureRequest.getImage().getBytes()));
		Picture uploadedPictureObj = pictureRepository.save(picture);

		UploadPictureResponse response = new UploadPictureResponse(200, uploadedPictureObj.getId(),
				uploadedPictureObj.getCategory(), uploadedPictureObj.getUrl(), uploadedPictureObj.getDescription());
		return ResponseEntity.ok(response);
	}

	@PostMapping("/unProcessedPictures")
	@RolesAllowed({ "ROLE_ADMIN", "ROLE_ADMINSTRATIVEUSER" })
	public ResponseEntity<UnProcessedPicturesResponse> unProcessedPictures() {
		try {
			UnProcessedPicturesResponse unProcessedPictures = new UnProcessedPicturesResponse(200,
					pictureRepository.unProcessedPictures());
			return ResponseEntity.ok(unProcessedPictures);
		} catch (Exception e) {
			UnProcessedPicturesResponse unProcessedPictures = new UnProcessedPicturesResponse(204, e.getMessage());
			return ResponseEntity.ok(unProcessedPictures);
		}

	}

	@PostMapping("/getPictureDetails")
	@RolesAllowed({ "ROLE_ADMIN" })
	public ResponseEntity<GetPictureDetailsResponse> getPictureDetails(@RequestBody Picture picture) {
		try {

			GetPictureDetailsResponse getPictureDetailsResponse = new GetPictureDetailsResponse(200,
					pictureRepository.findById(picture.getId()));
			return ResponseEntity.ok(getPictureDetailsResponse);
		} catch (Exception e) {
			GetPictureDetailsResponse getPictureDetailsResponse = new GetPictureDetailsResponse(204, e.getMessage(),
					"");
			return ResponseEntity.ok(getPictureDetailsResponse);
		}

	}

	@PostMapping("/acceptPicture")
	@RolesAllowed({ "ROLE_ADMIN" })
	public ResponseEntity<GetPictureDetailsResponse> acceptPicture(@RequestBody Picture picture) {
		try {
			pictureRepository.acceptPicture(picture.getId());
			GetPictureDetailsResponse getPictureDetailsResponse = new GetPictureDetailsResponse(200, "done", "");
			return ResponseEntity.ok(getPictureDetailsResponse);
		} catch (Exception e) {
			e.printStackTrace();
//			GetPictureDetailsResponse getPictureDetailsResponse=new GetPictureDetailsResponse(204,e.getMessage());
//			 return ResponseEntity.ok(getPictureDetailsResponse);
		}
		return null;
	}

	@PostMapping("/rejectPicture")
	@RolesAllowed({ "ROLE_ADMIN" })
	public ResponseEntity<GetPictureDetailsResponse> rejectPicture(@RequestBody Picture picture) {
		try {
			Files.delete(Paths.get(pictureRepository.findById(picture.getId()).get().getUrl()));
			pictureRepository.rejectPicture(picture.getId());

			return ResponseEntity.ok(new GetPictureDetailsResponse(200, "done", ""));
		} catch (Exception e) {
			// e.printStackTrace();
			GetPictureDetailsResponse getPictureDetailsResponse = new GetPictureDetailsResponse(204, e.getMessage(),
					"");
			return ResponseEntity.ok(getPictureDetailsResponse);
		}

	}

}