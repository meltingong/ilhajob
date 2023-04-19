package com.itwill.ilhajob.corp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corp.entity.Corp;

@Repository
public interface CorpRepository extends JpaRepository<Corp, Long> {
	
    Optional<Corp> findByCorpLoginId(String corpLoginId);
    boolean existsByCorpLoginId(String corpLoginId);
    
    //corpName으로 검색기능
    List<Corp> findByCorpNameContaining(String corpName);
    
    //job으로만 검색기능
    List<Corp> findByJobContaining(String job);
    
    //corpname이랑 job으로 검색하기
    List<Corp> findByCorpNameContainingAndJobContaining(String corpName, String job);
}
