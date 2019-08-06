package com.neu.mvcweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.neu.mvcweb.message.ResultMessage;
import com.neu.mvcweb.model.DepartmentModel;
import com.neu.mvcweb.pdf.PdfWordList;

@RestController

@RequestMapping(value="/api/department")
//@CrossOrigin(origins = {"*"})
public class DepartmentController {
	@RequestMapping(value="/add")
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	//@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason="服务器内部错误")
	public ResultMessage add(Optional<String> code,String name) throws Exception{
		
		//System.out.println(entity.getHeaders().size());
		//System.out.println(entity.getName());
		System.out.println(code.get());
		System.out.println(name);
		//int m=10/0;
		return new ResultMessage("OK", "增加部门成功");
	}
	
	@ExceptionHandler
	public ResultMessage handle(Exception ex) {
		return new ResultMessage("ERROR", ex.getMessage());
	}
	@RequestMapping(value="/pdf")
	public PdfWordList createPDF(Model model) throws Exception{
		
		List<String> list=new ArrayList<String>();
		list.add("AAA");
		list.add("BBB");
		list.add("CCC");
		model.addAttribute("wordList", list);
		
		return new PdfWordList();
		
	}

}
