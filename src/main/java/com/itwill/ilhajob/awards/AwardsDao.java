package com.itwill.ilhajob.awards;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface AwardsDao {
	
	Awards findAwards(int awardsSeq);
	
	int createAwards(Awards awards);
	
	int updateAwards(Awards awards);
	
	int removeAwards(Awards awards);
	
	List<Awards> findAwardsList();
	
	List<Awards> findAwardsOfUser(int userSeq);
}
