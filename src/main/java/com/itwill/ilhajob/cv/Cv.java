package com.itwill.ilhajob.cv;

import java.util.List;

import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.exp.Exp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cv {

	private String cvSeq;
	private String cvName;
	private String cvDescription;
	private String cvPortfolio;
	private String userEmail;
	private List<Edu> eduList;
	private List<Exp> expList;
	private List<Awards> awardsList;
	
}
