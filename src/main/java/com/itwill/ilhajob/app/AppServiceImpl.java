package com.itwill.ilhajob.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {
	@Autowired	
	private AppDao appDao;

	@Override
	public int insertApp(App app) {
		return appDao.insertApp(app);
	}

	@Override
	public int deleteApp(int appSeq) {
		return appDao.deleteApp(appSeq);
	}
	
	
	//CorpId로 지원한 app 수
	@Override
	public int findAppCountByCorpId(String corpId) {
		return appDao.findAppCountByCorpId(corpId);
	}
	
	
	
}
