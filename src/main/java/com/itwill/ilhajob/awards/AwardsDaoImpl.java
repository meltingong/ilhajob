package com.itwill.ilhajob.awards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.awards.mapper.AwardsMapper;

@Repository
public class AwardsDaoImpl implements AwardsDao{
	@Autowired
	private AwardsMapper awardsMapper;

	@Override
	public Awards findAwards(int awardsSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createAwards(Awards awards) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAwards(Awards awards) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAwards(Awards awards) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Awards> findAwardsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Awards> findAwardsOfUser(int userSeq) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
