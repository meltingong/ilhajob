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
		return  awardsMapper.selectByAwards(awardsSeq);
	}

	@Override
	public int createAwards(Awards awards) {
		return awardsMapper.insertAwards(awards);
	}

	@Override
	public int updateAwards(Awards awards) {
		return awardsMapper.updateAwards(awards);
	}

	@Override
	public int removeAwards(Awards awards) {
		return awardsMapper.removeAwards(awards);
	}

	@Override
	public List<Awards> findAwardsList() {
		return awardsMapper.selectAll();
	}

	@Override
	public List<Awards> findAwardsOfUser(int userSeq) {
		return awardsMapper.selectByAwardsOfUser(userSeq);
	}
	
	

}
