package com.itwill.ilhajob.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.itwill.ilhajob.corp.Corp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recruit_tag")
public class RecruitTag {
	
	@ManyToOne
	@JoinColumn(name = "recruit_id")
	private Recruit recruit;
	
	@ManyToOne
	@JoinColumn(name = "tag_id")
	private Tag tag;
}
