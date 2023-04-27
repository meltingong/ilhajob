package com.itwill.ilhajob.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.ilhajob.common.dto.ProductDto;
import com.itwill.ilhajob.common.service.OrdersService;
import com.itwill.ilhajob.common.service.ProductService;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Controller
public class ProductController {
	
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/shop")
	public String shop(HttpServletRequest request, Model model) throws Exception {
		String forwardPath = "";
		String pDiv=(String)request.getSession().getAttribute("pDiv");
		List<ProductDto> productList = productService.selectByDiv(pDiv);
		model.addAttribute("productList", productList);
		
	    forwardPath = "shop";
	    return forwardPath;
	}
	
	@RequestMapping(value = "/shop-single", params = "!id")
	public String shop_single() {
		return "redirect:shop";
	}
	
	@RequestMapping(value = "/shop-single", params = "id")
	public String shop_single(@RequestParam("id") Long Id , Model model) throws Exception {
		ProductDto productDto = productService.selectById(Id);
		model.addAttribute("product", productDto);
		return "shop-single";
	}
	
		
}