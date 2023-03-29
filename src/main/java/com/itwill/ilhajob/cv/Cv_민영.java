package com.itwill.ilhajob.cv;

import java.util.List;

import com.itwill.ilhajob.app.App;
import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.exp.Exp;

/*
 * 이름             널?       유형             
-------------- -------- -------------- 
CV_SEQ         NOT NULL NUMBER(20)     
CV_NAME                 VARCHAR2(30)   
CV_DESCRIPTION          VARCHAR2(1000) 
CV_PORTFOLIO            VARCHAR2(70)   
USER_SEQ                NUMBER(20)
 */
public class Cv_민영 {
	private int cvSeq;
	private String cvName;
	private String cvDescription;
	private String cvPortfolio;
	private int userSeq;
	private List<Edu> eduList;
	private List<Exp> expList;
	private List<Awards> awardsList;
	private List<App> appList;
}
