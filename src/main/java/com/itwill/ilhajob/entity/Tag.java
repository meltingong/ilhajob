package com.itwill.ilhajob.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tag")
public class Tag {
	
	@Id
	private int tagId;
	
	private String tagName;
	
	@OneToMany(mappedBy = "tag",
			   fetch = FetchType.EAGER)
	private List<RecruitTag> recruitTag;
	
	@OneToMany(mappedBy = "tag",
			   fetch = FetchType.EAGER)
	private List<CorpTag> corpTag;
}
