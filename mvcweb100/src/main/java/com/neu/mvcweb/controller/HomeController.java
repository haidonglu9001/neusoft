package com.neu.mvcweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.neu.mvcweb.model.UserModel;

@Controller
@RequestMapping(value="/home")
@SessionAttributes("um")
public class HomeController {
	@RequestMapping(value="/toindex")
	public Model tohome(HttpSession session,Model model,View view) throws Exception{
		session.setAttribute("userinfo", "LCO");
		UserModel um=new UserModel();
		um.setId("q1");
		um.setName("q2");
		um.setAge(100);
		model.addAttribute("um", um);
		
		
		
		System.out.println(" to index...");
		return model;
	}

}
