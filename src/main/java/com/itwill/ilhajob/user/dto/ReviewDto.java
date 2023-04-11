package com.itwill.ilhajob.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewDto {
	private long id;
	private String reviewGrade;
	private String reviewTitle;
	private String reviewContent;
	private int corpId;
	private int userSeq;
	
}
