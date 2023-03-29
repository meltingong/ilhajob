package com.itwill.ilhajob.blogComment;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCommentDao {
	
	// 블로그 댓글달기
	int insertBlogComment(BlogComment blogComment) throws Exception;
	
	// 회원 번호로 블로그 댓글 정보 가져오기
	BlogComment selectByBlogComment(int commentSeq) throws Exception;
	
	// 모든 블로그 댓글 가져오기
	List<BlogComment> selectAll() throws Exception;
	
	// 블로그 번호로 1개의 블로그 댓글 가져오기
	List<BlogComment> selectByBlogSeq(int blogSeq) throws Exception;
	
	// 블로그 댓글 수정하기
    int updateBlogComment(BlogComment blogComment) throws Exception;
    
    // 블로그 댓글 삭제하기
    int deleteBlogComment(int commentSeq) throws Exception;
}
