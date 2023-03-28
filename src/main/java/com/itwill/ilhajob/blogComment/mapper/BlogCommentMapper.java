package com.itwill.ilhajob.blogComment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.blogComment.BlogComment;

@Mapper
public interface BlogCommentMapper {
	
	public BlogComment selectByBlogComment(int commentSeq);
	/*
	<select id="selectByBlogComment" resultType="com.itwill.ilhajob.blogComment.BlogComment">
        select * from blogcomment where comment_seq = #{commentSeq}
    </select>
	*/
	
	public List<BlogComment> selectAll();
	/*
	<select id="selectAll" resultType="com.itwill.ilhajob.blogComment.BlogComment">
        select * from blogcomment
    </select>
	*/
	
	public List<BlogComment> selectByBlogSeq(int blogSeq);
	/*i
	<select id="selectByBlogSeq" resultType="com.itwill.ilhajob.blogComment.BlogComment">
        select * from blogcomment where blog_seq = #{blogSeq}
    </select>
	*/
	
	public int insertBlogComment(BlogComment blogComment);	
	/*
	<insert id="insertBlogComment" parameterType="com.itwill.ilhajob.blogComment.BlogComment">
        insert into blogcomment (comment_seq, comment_content, comment_date, user_seq, blog_seq)
        values (#{commentSeq}, #{commentContent}, #{commentDate}, #{userSeq}, #{blogSeq})
    </insert>
	*/
	
	public int updateBlogComment(BlogComment blogComment);	
	/*
	<update id="updateBlogComment" parameterType="com.itwill.ilhajob.blogComment.BlogComment">
        update blogcomment set comment_seq = #{commentSeq}, comment_content=#{commentContent},
        comment_date=#{commentDate}, user_seq=#{userSeq}, blog_seq=#{blogSeq}    
    </update> 
	*/
	
	public int deleteBlogComment(int commentSeq);
	/*
	<delete id="deleteBlogComment" parameterType="com.itwill.ilhajob.blogComment.BlogComment">
        delete from blogcomment where comment_seq = #{commentSeq}
    </delete> 
	*/
}
