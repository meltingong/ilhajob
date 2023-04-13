package com.itwill.ilhajob.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.common.entity.BlogComment;

public interface BlogCommentRepository extends JpaRepository<BlogComment, Long>{

}
