package com.itwill.ilhajob.cv;

import java.util.List;

public interface CvDao_하은 {
	
	Cv findCv(int cvSeq);
	
	List<Cv> findCvList();
	
	List<Cv> findCvListByUserSeq(int userSeq);
	
	//List<Cv> findCvOfUser(String userEmail);
	
	int createCv(Cv cv);
	
	int updateCv(Cv cv);
	
	int remove(int cvSeq);
}
