package com.itwill.ilhajob.exp;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exp {
	
	private int exp_seq;
	private String exp_position;
	private String exp_corpName;
	private Date exp_start_date;
	private Date exp_end_date;
	private String exp_content;
	private int user_seq;
	
}
