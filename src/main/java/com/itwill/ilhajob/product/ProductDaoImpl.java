package com.itwill.ilhajob.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.product.mapper.ProductMapper;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired(required = true)
	private ProductMapper productMapper;

	@Override
	public Product findByNo(int p_no) throws Exception {
		return productMapper.selectByNo(p_no);
	}

	@Override
	public List<Product> findAllByDiv(String p_div) throws Exception {
		return productMapper.selectAllByDiv(p_div);
	}

	@Override
	public int update(Product product) throws Exception {
		return productMapper.updateProduct(product);
	}

	@Override
	public int delete(int p_no) throws Exception {
		return productMapper.deleteProduct(p_no);
	}
	
	
}
