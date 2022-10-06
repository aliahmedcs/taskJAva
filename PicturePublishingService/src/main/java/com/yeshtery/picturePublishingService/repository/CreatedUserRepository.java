package com.yeshtery.picturePublishingService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yeshtery.picturePublishingService.model.Role;
import com.yeshtery.picturePublishingService.model.User;

@Repository
public interface CreatedUserRepository extends JpaRepository<User, Long> {
     
    Optional<User> findByEmail(String email);
    
    //@Query("SELECT u FROM user u WHERE u.user_name = :user_name")
   // Optional<User> findByUserName(@Param("user_name") String user_name);
    Optional<User> findByUserName( String user_name);

	//User findById(Long userId);

	

	
}