package com.itwill.ilhajob.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.product.Product;

@Mapper
public interface ProductMapper {
	
	public Product selectByNo(int p_no);
	
	public List<Product> selectAllByDiv(String p_div);
	
	public int updateProduct(Product product);
	
	public int deleteProduct(int p_no);
}
