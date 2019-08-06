package com.neu.mvcweb.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//WEBMVC 配置启动类，作用类似于web.xml的配置
//该类自动启动
public class WebMvcStarter extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] { AppRootConfig.class };
		//return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[] { WebContextConfig.class };
	}
	
	@Override
	protected String[] getServletMappings() {
		System.out.println("MVC配置启动了。。。");
		
		return new String[] { "/" };
	}
	@Override
    protected Filter[] getServletFilters() {//注册过滤器
		System.out.println("注册Filter了。。。");
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        //启用非GET和POST其他的请求方式，如PUT，DELETE等
        return new Filter[]{characterEncodingFilter,new HiddenHttpMethodFilter() };
    }
	
	//配置Multipart解析器
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration)
	{
		// Optionally also set maxFileSize, maxRequestSize, fileSizeThreshold
		registration.setMultipartConfig(new MultipartConfigElement("d:/temp",2000000,3000000,0));
		System.out.println("文件上传解析器配置。。。");
	}
	
	
	



}
