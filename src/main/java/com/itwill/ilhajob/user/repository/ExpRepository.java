package com.itwill.ilhajob.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.user.entity.Exp;

@Repository
public interface ExpRepository extends JpaRepository<Exp, Long> {

}
