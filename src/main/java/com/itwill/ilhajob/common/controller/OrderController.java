package com.itwill.ilhajob.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.ilhajob.common.dto.PaymentDto;
import com.itwill.ilhajob.common.service.OrdersService;
import com.itwill.ilhajob.user.dto.UserDto;

@Controller
public class OrderController {
	
	private final OrdersService ordersService;
	
	@Autowired
	public OrderController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	@GetMapping("/pricing")
	public String pricing(HttpServletRequest request) {
		//System.out.println(">>>>>>>>"+sUserId);
		String forwardPath = "pricing";
		return forwardPath;
	}
	
	@GetMapping("/dashboard-change-password")
	public String changePassword(HttpServletRequest request) {
		//System.out.println(">>>>>>>>"+sUserId);
		String forwardPath = "dashboard-change-password";
		return forwardPath;
	}
	
	@GetMapping("/shop-checkout")
	public String shopChecked(HttpServletRequest request) {
		//System.out.println(">>>>>>>>"+sUserId);
		String forwardPath = "shop-checkout";
		return forwardPath;
	}
	
	@GetMapping("/order-completed")
	public String orderCompleted(HttpServletRequest request) {
		//System.out.println(">>>>>>>>"+sUserId);
		String forwardPath = "order-completed";
		return forwardPath;
	}
	
	@GetMapping("/invoice")
	public String invoice(HttpServletRequest request, Model model) {
		String forwardPath = "";
		request.getSession().getAttribute("role");
		List<PaymentDto> paymentList = ordersService.findPayment("user", 1L);
		int totalPrice = paymentList.stream().mapToInt(PaymentDto::getPaymentPrice).sum();
		model.addAttribute("paymentList", paymentList);
		model.addAttribute("totalPrice", totalPrice);

		forwardPath = "invoice";
		return forwardPath;
	}
}
