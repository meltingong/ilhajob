package com.itwill.ilhajob.order;

import com.itwill.ilhajob.product.Product;

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
public class Orders {
	private int order_no;
	private Product p_no;
	private String corp_id;
	private int user_seq;
	
	
}
