package com.yeshtery.picturePublishingService.response;

import java.util.Optional;

import com.yeshtery.picturePublishingService.model.Picture;

public class GetPictureDetailsResponse {
 private int status;
 private Object object;
 private String bla;
 public Object getObject() {
	return object;
}
public void setObject(Object object) {
	this.object = object;
}
public String getBla() {
	return bla;
}
public void setBla(String bla) {
	this.bla = bla;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Optional<Picture> getPicture() {
	return picture;
}
public void setPicture(Optional<Picture> picture) {
	this.picture = picture;
}
private Optional<Picture> picture;
public GetPictureDetailsResponse(int status, Optional<Picture> picture) {
	
	this.status = status;
	this.picture = picture;
}
public GetPictureDetailsResponse(int status, String object,String bla) {
	
	this.status = status;
	this.object = object;
}
}
