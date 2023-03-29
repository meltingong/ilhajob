package com.itwill.ilhajob.blogComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCommentDao {
	@Autowired
	BlogComment findBlogComment(int commentSeq);
	
	// 모든 블로그 댓글 리스트 가져오기
	List<BlogComment> selectAll()throws Exception;	
	
    List<BlogComment> selectByBlogCommentUser(int userSeq);
	
	int insertBlogComment(BlogComment blogComment);
	
	// 블로그 댓글 수정하기
    int updateBlogComment(BlogComment blogComment);
    
    // 블로그 댓글 삭제하기
    int removeBlogComment(BlogComment blogComment);
}
