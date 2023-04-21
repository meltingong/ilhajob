package com.itwill.ilhajob.user.dto;


import com.itwill.ilhajob.corp.entity.Recruit;
import com.itwill.ilhajob.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RecruitScrapDto {
	private Long id;
	private User user;
	private Recruit recruit;
}
