package com.yeshtery.picturePublishingService.response;

import java.util.List;
import java.util.Optional;

import com.yeshtery.picturePublishingService.model.Picture;

public class UnProcessedPicturesResponse {
	
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	private Object object;
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}


	private  Optional<List<Picture>> picture;
	public  Optional<List<Picture>> getPicture() {
		return picture;
	}
	public void setPicture( Optional<List<Picture>> picture) {
		this.picture = picture;
	}
	public UnProcessedPicturesResponse(int status, Object object) {
		
		this.status = status;
		this.object = object;
		
	}
	

}
