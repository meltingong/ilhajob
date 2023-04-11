package com.itwill.ilhajob.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.ilhajob.user.dto.CvDto;
import com.itwill.ilhajob.user.entity.Cv;

public interface CvRepository extends JpaRepository<Cv, Long> {
	
//	@Query(value = "select * from cv where user_id = :userId", nativeQuery = true)
	List<CvDto> findCvByUserId(Long userId);

}
