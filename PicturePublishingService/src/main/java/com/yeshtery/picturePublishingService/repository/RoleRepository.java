package com.yeshtery.picturePublishingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yeshtery.picturePublishingService.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	
}