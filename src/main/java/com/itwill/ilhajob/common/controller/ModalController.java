package com.itwill.ilhajob.common.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itwill.ilhajob.common.dto.ProductDto;
import com.itwill.ilhajob.common.entity.Product;
import com.itwill.ilhajob.common.service.ProductService;

@RestController
public class ModalController {

	@Autowired
	private ProductService productService;
	
    @GetMapping("/login-popup")
    public ResponseEntity<String> showLoginPopup() {
    	String html = ""; // html 파일 내용을 읽어와서 변수에 저장

    	try {
    	    Resource resource = new ClassPathResource("templates/login-popup.html");
    	    InputStream inputStream = resource.getInputStream();
    	    html = new BufferedReader(new InputStreamReader(inputStream))
    	         .lines().collect(Collectors.joining("\n"));
    	} catch (IOException e) {
    	     e.printStackTrace();
    	     // 예외 처리
    	}

    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_HTML);

    	return new ResponseEntity<>(html, headers, HttpStatus.OK);
    }
    
    @GetMapping("/register-popup")
    public ResponseEntity<String> showRegisterPopup() {
    	String html = "";
    	try {
    	    Resource resource = new ClassPathResource("templates/register-popup.html");
    	    InputStream inputStream = resource.getInputStream();
    	    html = new BufferedReader(new InputStreamReader(inputStream))
    	         .lines().collect(Collectors.joining("\n"));
    	} catch (IOException e) {
    	     e.printStackTrace();
    	     // 예외 처리
    	}

    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_HTML);

    	return new ResponseEntity<>(html, headers, HttpStatus.OK);
    }
    
    @GetMapping("/apply-popup")
    public ResponseEntity<String> showApplyPopup() {
    	String html = "";

    	try {
    	    Resource resource = new ClassPathResource("templates/apply-popup.html");
    	    InputStream inputStream = resource.getInputStream();
    	    html = new BufferedReader(new InputStreamReader(inputStream))
    	         .lines().collect(Collectors.joining("\n"));
    	} catch (IOException e) {
    	     e.printStackTrace();
    	     // 예외 처리
    	}

    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_HTML);

    	return new ResponseEntity<>(html, headers, HttpStatus.OK);
    }

//	@GetMapping("/order-popup")
//	public ResponseEntity<String> showOrderPopup() {
//		String html = ""; // html 파일 내용을 읽어와서 변수에 저장
//
//		try {
//			Resource resource = new ClassPathResource("templates/order-popup.html");
//			InputStream inputStream = resource.getInputStream();
//			html = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
//		} catch (IOException e) {
//			e.printStackTrace();
//			// 예외 처리
//		}
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.TEXT_HTML);
//
//		return new ResponseEntity<>(html, headers, HttpStatus.OK);
//	}
//	 @PostMapping("order-popup")
//	 public ResponseEntity<Object> orderPopup(@RequestBody ProductDto productDto) throws Exception {
//		String html = ""; // html 파일 내용을 읽어와서 변수에 저장
//		System.out.println(productDto);
//	    ProductDto product = productService.selectById(productDto.getId());
//	    System.out.println(product);
//		try {
//			Resource resource = new ClassPathResource("templates/order-popup.html");
//			InputStream inputStream = resource.getInputStream();
//			html = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	    // 응답에 담을 Map 객체 생성
//	    Map<String, Object> data = new HashMap<>();
//	    data.put("html", html);
//	    data.put("product", product);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		return new ResponseEntity<>(html, headers, HttpStatus.OK);
//	 }
    
    @PostMapping("order-popup")
    public ResponseEntity<Object> getProductInfo(@RequestBody ProductDto productDto) throws Exception {
        ProductDto product = productService.selectById(productDto.getId());

        String html = "";
        try {
            Resource resource = new ClassPathResource("templates/order-popup.html");
            InputStream inputStream = resource.getInputStream();
            html = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            // 예외 처리
        }

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("html", html);
        responseData.put("product", product);

        return ResponseEntity.ok(responseData);
    }
}
