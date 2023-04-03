package com.itwill.ilhajob.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "product")
public class Product {
	private int pNo;
	private String pName;
	private int pPrice;
	private int pEndMonth;
	private String pImage;
	private String pDiv;
	
	@OneToMany(mappedBy = "product",
			   fetch = FetchType.EAGER)
	private List<Order> orderList;
}
