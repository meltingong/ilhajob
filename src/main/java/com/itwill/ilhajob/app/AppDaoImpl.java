package com.itwill.ilhajob.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.app.mapper.AppMapper;
import com.itwill.ilhajob.corp.mapper.CorpMapper;

@Repository
public class AppDaoImpl implements AppDao {

	@Autowired
	private AppMapper appMapper;
	
	/*
	@Override
	public List<App> findAppByUserSeq(int userSeq) {
		return appMapper.findAppByUserSeq(userSeq);
	}

	@Override
	public List<App> findAppByCorpId(String coprId) {
		return appMapper.findAppByCorpId(coprId);
	}
	*/
	@Override
	public int insertApp(App app) {
		return appMapper.insertApp(app);
	}

	@Override
	public int deleteApp(int appSeq) {
		return appMapper.deleteApp(appSeq);
	}

}
