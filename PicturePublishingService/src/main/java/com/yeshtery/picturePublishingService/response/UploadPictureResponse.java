package com.yeshtery.picturePublishingService.response;

public class UploadPictureResponse {
	public UploadPictureResponse(int status,long id, String category, String url, String description) {
		
		this.status = status;
		this.id = id;
		this.category = category;
		this.url = url;
		this.description = description;
	}
public UploadPictureResponse(int status, String message) {
		
		this.status = status;
		this.category = message;
		
	}
	private int status;
	private long id;
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private String category;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String url;
	private String description;
}
