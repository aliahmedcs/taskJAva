package com.yeshtery.picturePublishingService.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
 
import org.hibernate.validator.constraints.Length;
 
public class AuthRequest {
	
	 @Email @Length(min = 5, max = 50)
    private String email;
     
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@NotNull @Length(min = 4, max = 20)
    private String password;
    
    @NotNull @Length(min = 4, max = 50)
    private String userName;
    
     @Length(min = 4, max = 50)
    private String address;
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
 
    
}