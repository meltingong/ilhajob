package com.itwill.ilhajob.common.dto;


import java.util.List;

import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.user.dto.CvDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.entity.Message;

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
public class AppDto {
	
	private long id;
	private char appStatus;
	@ToString.Exclude
	private RecruitDto recruit;
	@ToString.Exclude
	private CvDto cv;
	@ToString.Exclude
	private UserDto user;
	@ToString.Exclude
	private CorpDto corp;
}
