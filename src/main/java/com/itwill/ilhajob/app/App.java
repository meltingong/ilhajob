package com.itwill.ilhajob.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class App {
	
	private String appSeq;
	private String appStatus;
	private String rcSeq;
	private String cvSeq;

}
