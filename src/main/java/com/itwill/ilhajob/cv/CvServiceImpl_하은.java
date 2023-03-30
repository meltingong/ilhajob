package com.itwill.ilhajob.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvServiceImpl_하은 implements CvService_하은{

	@Autowired
	private CvDao_하은 cvDao;

	public CvServiceImpl_하은(CvDao_하은 cvDao) {
		this.cvDao = cvDao;
	}

	public CvDao_하은 getCvDao() {
		return cvDao;
	}

	public void setCvDao(CvDao_하은 cvDao) {
		this.cvDao = cvDao;
	}

	@Override
	public Cv findCv(int cvSeq) {
		return cvDao.findCv(cvSeq);
	}
	
	@Override
	public List<Cv> findCvList() {
		return cvDao.findCvList();
	}

	@Override
	public List<Cv> findCvListByUserSeq(int userSeq) {
		return cvDao.findCvListByUserSeq(userSeq);
	}

	@Override
	public int createCv(Cv cv) {
		return cvDao.createCv(cv);
	}

	@Override
	public int updateCv(Cv cv) {
		return cvDao.updateCv(cv);
	}

	@Override
	public int remove(int cvSeq) {
		return cvDao.remove(cvSeq);
	}

	@Override
	public Cv detailCv(int userSeq, int cvSeq) {
		return cvDao.detailCv(userSeq, cvSeq);
	}



}
