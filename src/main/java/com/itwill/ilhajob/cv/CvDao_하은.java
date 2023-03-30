package com.itwill.ilhajob.cv;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface CvDao_하은 {
	
	Cv findCv(int cvSeq);
	
	List<Cv> findCvList();
	
	List<Cv> findCvListByUserSeq(int userSeq);
	
	//List<Cv> findCvOfUser(String userEmail);
	
	Cv detailCv(int userSeq, int cvSeq);
	
	int createCv(Cv cv);
	
	int updateCv(Cv cv);
	
	int remove(int cvSeq);
}
