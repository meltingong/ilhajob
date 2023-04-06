package com.itwill.ilhajob.app;

public interface AppService {
	
	int insertApp(App app);
	
	int deleteApp(int appSeq);
	
	int findAppCountByCorpId(String corpId);
}
