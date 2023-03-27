package com.itwill.ilhajob.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Review {
	int review_seq;
	String review_grade;
	String review_title;
	String review_content;
	String user_email;
	String corp_id;
	
}
