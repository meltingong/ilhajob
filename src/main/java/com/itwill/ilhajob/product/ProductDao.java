package com.itwill.ilhajob.product;

import java.util.List;

public interface ProductDao {
	
	Product findNo(int p_no);
	
	List<Product> findAllByDiv(String p_div);
	
	int update(Product product);
	
	int delete(int p_no);
}
