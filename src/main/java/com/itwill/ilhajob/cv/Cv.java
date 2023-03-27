package com.itwill.ilhajob.cv;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
}
