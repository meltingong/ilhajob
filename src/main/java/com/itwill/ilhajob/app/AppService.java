package com.itwill.ilhajob.app;

public interface AppService {
	
	int insertApp(App app);
	
	int deleteApp(App app);
	
	int findAppCountByCorpId(String corpId);
}
