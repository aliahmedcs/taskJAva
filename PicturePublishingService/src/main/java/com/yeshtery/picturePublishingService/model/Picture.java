package com.yeshtery.picturePublishingService.model;

import java.io.Serializable;

import javax.persistence.Column;
//import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.basic.Inet;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLInetType;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "picture")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@TypeDef(
//	    name = "category",
//	    typeClass = Category.class,
//	    defaultForType = String.class
//	)
public class Picture implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(columnDefinition = "text")
private String description;
@Column(columnDefinition = "text")
  private String url;
  
  private Boolean isAccepted;
	
	

//  @Enumerated(EnumType.STRING)
 // @Column(name="category",columnDefinition = "ENUM('living thing','nature','machine')")  
//  @Enumerated(EnumType.STRING)
//  private Category category
//@Enumerated(EnumType.STRING)
private String category;
  
////  @Column(
////	        name = "category",
////	        columnDefinition = "integer[]"
////	    )
////	    private int[] categories;
//	 

//  @Column(
//      name = "category",
//      columnDefinition = "category[]"
//  )
//  private Category[] category;
  public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public Boolean getIsAccepted() {
	return isAccepted;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public void setIsAccepted(Boolean isAccepted) {
	this.isAccepted = isAccepted;
}
//@Enumerated(EnumType.STRING)
//public String getCategory() {
//	if(category==null) {
//		return null;
//	}
//	return category.name();
//}
////@Enumerated(EnumType.STRING)
//public void setCategory(String category) {
//	if(category==null) {
//		category="nature";
//	}
//	this.category = Category.valueOf(category);
//}


  
  
}
