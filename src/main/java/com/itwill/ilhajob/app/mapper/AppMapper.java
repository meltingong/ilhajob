package com.itwill.ilhajob.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.app.App;

@Mapper
public interface AppMapper {
	public App selectByApp(int appSeq);
	/*
    <select id="selectByApp" parameterType="string" resultType="com.itwill.ilhajob.app.App">
        select app_seq,app_status,rc_seq,cv_seq from app where app_seq=#{app_seq}
    </select>    
	 */
	public List<App> selectAll();
	/*
    <select id="selectAll" resultType="com.itwill.ilhajob.app.App">
        select app_seq,app_status,rc_seq,cv_seq from app
    </select>    
	*/
	public List<App> selectByAppOfRcSeq(String rcSeq);
	
	public List<App> selectByAppOfCvSeq(String cvSeq);
	
	public int insertApp(App app);
	/*
	<insert id="insertApp" parameterType="com.itwill.ilhajob.app.App">
	    insert into app(app_seq,app_status,rc_seq,cv_seq) values(#{app_seq},#{app_status,#{rc_seq},#{cv_seq})
	</insert>    
	*/
	public int updateApp(App app);
	/*
	<update id="updateApp" parameterType="com.itwill.ilhajob.app.App">
	    update app set app_status=#{app_status},rc_seq=#{rc_seq},cv_seq=#{cv_seq} where app_seq=#{app_seq}
	</update>    
	*/
	public int deleteApp(String appSeq);
	/*
	<delete id="deleteApp" parameterType="int">
	    delete app where app_seq=#{app_seq}
	</delete>    
	*/
   
    
}