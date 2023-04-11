package com.itwill.ilhajob.common.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ilhajob.common.dto.LoginDto;

@RestController
public class AuthController {

	 @PostMapping("final-project-team1-ilhajob/ajaxLogin")
	 public ResponseEntity<Object> ajaxLogin(@RequestBody LoginDto loginDto) {
		 String email = loginDto.getUserEmail();
	     String password = loginDto.getPassword();
	     System.out.println(loginDto);

	     // 로그인 처리
	     if (loginSuccess(email, password)) {
	         // 인증 성공 시 HttpStatus.OK와 성공 메시지 반환
	         return ResponseEntity.ok().body("{\"success\": true, \"message\": \"로그인 성공\"}");
	     } else {
	         // 인증 실패 시 HttpStatus.UNAUTHORIZED와 오류 메시지 반환
	         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false, \"message\": \"이메일 또는 비밀번호가 올바르지 않습니다.\"}");
	     }
	 }
	 
	 private boolean loginSuccess(String email, String password) {
		 
	     return true;
	 }
}
