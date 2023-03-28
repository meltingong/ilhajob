package com.itwill.ilhajob.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.blog.Blog;
import com.itwill.ilhajob.blogComment.BlogComment;

@Mapper
public interface BlogMapper {
	
	public Blog selectByBlog(int blogSeq);
	/*
	<select id="selectByBlog" resultType="com.itwill.ilhajob.blog.Blog">
        select * from blog where blog_seq = #{blogSeq}
    </select>
	 */
	
	public List<Blog> selectAll();
	/*
	<select id="selectAll" resultType="com.itwill.ilhajob.blog.Blog">
        select * from blog
    </select>
	*/
	
	public List<Blog> selectByBlogCateSeq(int blogCateSeq);
	/*
	<select id="selectByBlogCateSeq" resultType="com.itwill.ilhajob.blog.Blog">
        select * from blog where blog_cate_seq = #{blogCateSeq}
    </select>
	*/
	
	public int insertBlog(Blog blog);
	/*
	<insert id="insertBlog" parameterType="com.itwill.ilhajob.blog.Blog">
        insert into blog (blog_seq, blog_title, blog_content, blog_image, blog_date, blog_read_count, blog_like, user_email, blog_cate_seq) 
        values (#{blogSeq}, #{blogTitle}, #{blogContent}, #{blogImage}, #{blogDate}, #{blogRead}, #{blogReadCount}, #{blogLike}, #{userEmail}, #{blogCateSeq})
    </insert>
	*/
	
	public int updateBlog(Blog blog);
	/*
	<update id="updateBlog" parameterType="com.itwill.ilhajob.blog.Blog">
        update blog set blog_seq = #{blogSeq}, blog_title=#{blogTitle}, blog_content=#{blogContent}, blog_image=#{blogImage}, blog_date=#{blogDate},
        blog_read_count=#{blogReadCount}, blog_like=#{blogLike}, user_email=#{userEmail}, blog_cate_seq=#{blogCateSeq}
    </update>
	*/
	
	public int deleteBlog(int blogSeq);
	/*
	<delete id="deleteBlog" parameterType="com.itwill.ilhajob.blog.Blog">
        delete from blog where blog_seq = #{blogSeq}
    </delete>
	*/

}
