package com.itwill.ilhajob.product;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private int p_no;
	private String p_name;
	private int p_price;
	private Date p_date;
	private String p_image;
	private String p_div;
}
