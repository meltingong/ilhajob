package com.itwill.ilhajob.common.service;

import java.util.List;

import com.itwill.ilhajob.common.dto.BlogCommentDto;

public interface BlogCommentService {
	
	/*
	 * findBlogComment(블로그댓글seq로 찾기)
	 */
	BlogCommentDto findBlogComment(Long id);
	
	/*
	 * selectAll(블로그댓글list)
	 */
	List<BlogCommentDto> selectAll();

	/* selectByBlogComment(블로그seq로 찾기)
	List<BlogCommentDto> selectByBlogComment(Long id);
	 */
	
	/*
	 * blogComment insert
	 */
    BlogCommentDto insertBlogComment(BlogCommentDto blogComment) throws Exception;
	
	/*
    int updateBlogComment(BlogCommentDto blogComment);
    int deleteBlogComment(int commentSeq);
    List<BlogCommentDto> findByUserSeqCommnt(int userSeq);
     */
    
    /*
     * blogComment update
     */
    
    /*
     * blogComment delete
     */


}
