package com.itwill.ilhajob.product;

import java.util.List;

public interface ProductDao {
	
	Product findByNo(int p_no) throws Exception;
	
	List<Product> findAllByDiv(String p_div) throws Exception;
	
	int update(Product product) throws Exception;
	
	int delete(int p_no) throws Exception;
}
