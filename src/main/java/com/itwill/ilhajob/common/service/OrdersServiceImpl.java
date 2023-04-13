package com.itwill.ilhajob.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.common.dto.OrdersDto;
import com.itwill.ilhajob.common.dto.ProductDto;
import com.itwill.ilhajob.common.entity.Orders;
import com.itwill.ilhajob.common.repository.OrdersRepository;
import com.itwill.ilhajob.common.repository.ProductRepository;

@Service
public class OrdersServiceImpl implements OrdersService{

	private final OrdersRepository ordersRepository;
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public OrdersServiceImpl(OrdersRepository ordersRepository, ProductRepository productRepository ,ModelMapper modelMapper) {
		this.ordersRepository = ordersRepository;
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void saveOrder(OrdersDto ordersDto) {
		Orders saveOrder = modelMapper.map(ordersDto, Orders.class);
		ordersRepository.save(saveOrder);
	}

	@Override
	public void removeOrder() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<OrdersDto> findOrderByUser(long id) {
		List<Orders> findOrderList = ordersRepository.findByUserId(id);
		List<OrdersDto> orderList = findOrderList.stream()
				.map(order -> modelMapper.map(order, OrdersDto.class))
				.collect(Collectors.toList());
		return orderList;
	}

	@Override
	public List<OrdersDto> findOrderByCorp(long id) {
		List<Orders> findOrderList = ordersRepository.findByCorpId(id);
		List<OrdersDto> orderList = findOrderList.stream()
				.map(order -> modelMapper.map(order, OrdersDto.class))
				.collect(Collectors.toList());
		return orderList;
	}

	// 재구매시 시작일, 만료일 변경
	@Override
	public void updateOrder(OrdersDto ordersDto) {
		
	}

	@Override
	public OrdersDto reorderingCheck(String role, long id) {
		List<Orders> ordersList = new ArrayList<Orders>();
		if(role.equals("user")) {
			ordersList = ordersRepository.findByUserId(id);
		}else if(role.equals("corp")) {
			ordersList = ordersRepository.findByCorpId(id);
		}
		return null;
	}
	
	
	
}
