package com.yeshtery.picturePublishingService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.yeshtery.picturePublishingService.model.Picture;
 
@Repository
@Transactional
public interface PictureRepository extends JpaRepository<Picture, Long> {
	Optional<Picture> findById(Long id);
	
	@Query(value="SELECT * FROM picture  WHERE is_accepted IS NULL",nativeQuery = true)
	Optional<List<Picture>>  unProcessedPictures();
	
	@Query(value="SELECT * FROM picture WHERE is_accepted IS true",nativeQuery = true)
	Optional<List<Picture>>  acceptedPictures();
	
	@Modifying
	@Query(value="update picture set is_accepted=true WHERE id=(:id)",nativeQuery = true)
    void acceptPicture(@Param("id") Long id);
	@Modifying
	@Query(value="update picture set is_accepted=false,url=null WHERE id=(:id)",nativeQuery = true)
	void rejectPicture(@Param("id") Long id);
	
	
}
