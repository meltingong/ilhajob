package com.itwill.ilhajob.cv;

import java.util.List;

import com.itwill.ilhajob.app.App;
import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.exp.Exp;
import com.itwill.ilhajob.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cv {

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
