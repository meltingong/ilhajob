package com.itwill.ilhajob.app;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.app.mapper.AppMapper;
import com.itwill.ilhajob.user.User;
@Repository
public interface AppDao {
	
	int insertApp(App app);
	
	int deleteApp(int appSeq);
	
	List<App> findAppByUserSeq(int userSeq);
	
	List<App> findAppByCorpId(String coprId);

	
}
