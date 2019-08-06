package com.neu.mvcweb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.neu.mvcweb.model.UserModel;

//用户控制器类
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	
	
	@RequestMapping(value="/tomain")
	public String tomain(@ModelAttribute("user") UserModel um,@SessionAttribute("userinfo") String info,@SessionAttribute("um") UserModel uumm ) throws Exception{
		
		System.out.println(um.getId());
		
		System.out.println(info);
		
		System.out.println(uumm.getId());
		
		
		return "user/main";
	}
	@RequestMapping(value="/get")
	public ResponseEntity<UserModel> getUser(){
		UserModel um=new UserModel();
		um.setId("x1");
		um.setName("x2");
		um.setAge(200);
		
		//return ResponseEntity.ok().header("token","999999").body(um);
		MultiValueMap<String, String> headersMap=new LinkedMultiValueMap<String,String>();
		headersMap.add("token", "9999");
		headersMap.add("username", "LHD");
		return new ResponseEntity<UserModel>(um,headersMap,HttpStatus.OK);
	}
	
	@RequestMapping(value="/check")
	public HttpHeaders checkUser(String userid,String password) throws Exception{
		HttpHeaders headers=new HttpHeaders();
		headers.add("checkstatus", "NOT");
		return headers;
	}
	
	

}
