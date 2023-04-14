package com.itwill.ilhajob.corp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.corp.entity.Manager;


public interface ManagerRepository extends JpaRepository<Manager, Long> {
	public List<Manager> findByCorpId(Long corpID);
}
