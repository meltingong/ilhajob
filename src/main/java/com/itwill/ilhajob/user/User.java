package com.itwill.ilhajob.user;

import java.util.List;

import com.itwill.ilhajob.cv.Cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private String userEmail;
	private String password;
	private String userName;
	private String userPhone;
	private String userSex;
	private String userAddress;
	private String userCareer;
	private int userAge;
	private String userFinalEducation;
	private String userLanguage;
	private String userSkills;
	private String userImage;
	private String userStatus;
	private String snsType;
	private String snsId;
	private String job;
	private int role;

	/*
	 *패쓰워드 일치여부 검사 
	 */
	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.password.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}


}







