package com.itwill.ilhajob.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvServiceImpl_하은 implements CvService_하은{

	@Autowired
	private CvDao cvDao;
	
	public CvServiceImpl_하은(CvDao cvDao) {
		this.cvDao = cvDao;
	}

	public CvDao getCvDao() {
		return cvDao;
	}

	public void setCvDao(CvDao cvDao) {
		this.cvDao = cvDao;
	}

	@Override
	public Cv findCv(int cvSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cv> findCvList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cv> findCvListByUserSeq(int userSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createCv(Cv cv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCv(Cv cv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(int cvSeq) {
		// TODO Auto-generated method stub
		return 0;
	}
}
