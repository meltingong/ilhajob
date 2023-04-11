package com.itwill.ilhajob.user.dto;

import java.util.List;

import org.springframework.lang.Nullable;

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
public class CvDto {

	private Long cvSeq;
	private String cvName;
	private String cvDescription;
	private String cvPortfolio;
	private List<EduDto> eduList;
	private List<ExpDto> expList;
	private List<AwardsDto> awardsList;
	@ToString.Exclude
	private UserDto user;

	public CvDto(Long cvSeq, String cvName, String cvDescription, String cvPortfolio, UserDto user) {
		this.cvSeq = cvSeq;
		this.cvName = cvName;
		this.cvDescription = cvDescription;
		this.cvPortfolio = cvPortfolio;
		this.user = user;
	}
}
