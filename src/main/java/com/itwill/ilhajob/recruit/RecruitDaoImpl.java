package com.itwill.ilhajob.recruit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.recruit.mapper.RecruitMapper;

@Repository
public class RecruitDaoImpl implements RecruitDao {

    private RecruitMapper recruitMapper;

    @Autowired
    public RecruitDaoImpl(RecruitMapper recruitMapper) {
        this.recruitMapper = recruitMapper;
    }

    @Override
    public int insertRecruit(Recruit recruit) throws Exception {
        return recruitMapper.insertRecruit(recruit);
    }

    @Override
    public List<Recruit> findByCorpId(String corpId) throws Exception {
        return recruitMapper.findByCorpId(corpId);
    }

    @Override
    public List<Recruit> findByJob(String job) throws Exception {
        return recruitMapper.findByJob(job);
    }

    @Override
    public Recruit findBySeq(int rcSeq) throws Exception {
        return recruitMapper.findBySeq(rcSeq);
    }

    @Override
    public int updateBySeq(Recruit recruit) throws Exception {
        return recruitMapper.updateBySeq(recruit);
    }

    @Override
    public int deleteBySeq(int rcSeq, String corpId) throws Exception {
        return recruitMapper.deleteBySeq(rcSeq, corpId);
    }
	
	
}
