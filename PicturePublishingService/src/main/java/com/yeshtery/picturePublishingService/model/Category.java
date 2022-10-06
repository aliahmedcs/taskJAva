package com.yeshtery.picturePublishingService.model;



import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

//public enum Category {
//	living_thing, machine, nature
//}
public enum Category {

	LIVING_THING("living thing"),
	NATURE("nature"),
	MACHINE("machine");
	
	private String category;
	
	private Category(String category) {
		this.category=category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
//	@JsonCreator
//	public static Category decode(final String category) {
//		return Stream.of(Category.values()).filter(targetEnum -> targetEnum.category.equals(category)).findFirst().orElse(null);
//	}
//	
//	@JsonValue
//	public String getCategory() {
//		return category;
//	}
}