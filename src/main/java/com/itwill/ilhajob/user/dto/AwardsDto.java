package com.itwill.ilhajob.user.dto;

import java.util.Date;

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
public class AwardsDto {
	private Long id;
	private String awardsName;
	private Date awardsDate;
	private String awardsContent;
	@ToString.Exclude
	private UserDto user;
}
