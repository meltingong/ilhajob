package com.itwill.ilhajob.blogComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCommentDao {
	
	// 블로그 댓글 번호로  댓글 조회하기
	BlogComment findBlogComment(int commentSeq);
	
	// 블로그 댓글 모두 조회하기
	List<BlogComment> selectAll();
	
	// 블로그 댓글 블로그 번호로 조회하기
    List<BlogComment> selectByBlogComment(int blogSeq);
    
	// 블로그 댓글 추가하기
	int insertBlogComment(BlogComment blogComment);
	
	// 블로그 댓글 수정하기
    int updateBlogComment(BlogComment blogComment);
    
    // 블로그 댓글 삭제하기
    int deleteBlogComment(int commentSeq);
    
}
