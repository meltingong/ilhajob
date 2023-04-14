package com.itwill.ilhajob.common.service;

import java.util.List;

import com.itwill.ilhajob.common.dto.OrdersDto;
import com.itwill.ilhajob.common.dto.ProductDto;
import com.itwill.ilhajob.common.entity.Orders;

public interface OrdersService {
	//Orders savaOrder(String role, long id, ProductDto productDto);
	boolean checkAndSaveOrder(String role, long id, ProductDto productDto, String paymentMethod);
	void removeOrder();
	List<OrdersDto> findOrderByUser(long id);
	List<OrdersDto> findOrderByCorp(long id);
	void reorderingCheckUpdate(String role, long id);
}
