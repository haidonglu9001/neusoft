package com.neu.mvcweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

//Web Context级别IoC容器配置类
@Configuration
@ComponentScan(basePackages = { "com.neu.mvcweb" })
@EnableWebMvc
//注意：
//使用WebMvcConfigurationSupport（继承）或实现接口：WebMvcConfigurer
//public class WebContextConfig extends WebMvcConfigurationSupport
//public class WebContextConfig implements WebMvcConfigurer
public class WebContextConfig implements WebMvcConfigurer {

	// 配置静态资源
	//  配置默认的defaultServlet处理
    // <mvc:default-servlet-handler/>
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 配置静态资源处理
        configurer.enable("default");//对静态资源的请求转发到容器缺省的servlet，而不使用DispatcherServlet
    }

	/**
     * 静态资源访问控制：假如defaultServlet 没有过滤到接收的静态资源是会报404的
     * 配置addResourceHandlers 不能继承WebMvcConfigurationSupport
     * 因为它拥有子类DelegatingWebMvcConfiguration 已经重写了这个方法。所以运行时，在它方法debug的时候，
     * 发现我写的方法一点用都没 注意！！！
     * 下面相当于
     * <mvc:resources mapping="/resources/**"    location="/statics/" />
     * 支持location="classpath:xxxxx"
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/views/");
       
    }

    //JSP解析器
	@Bean
	public ViewResolver configureViewResolver() {
		InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
		viewResolve.setPrefix("/");
		viewResolve.setSuffix(".jsp");

		return viewResolve;
	}
	
	//文件上传Multipart解析器，在Servlet3.1以后版本的服务器内置的文件上传组件支持下工作
	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver resolver() {
		return new StandardServletMultipartResolver();
	}
	

	/*
	 * InternalResourceViewResolver的另外一种配置代码
	 * 
	 * @Bean public InternalResourceViewResolver getInternalResourceViewResolver() {
	 * InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 * resolver.setViewClass(JstlView.class); resolver.setPrefix("/WEB-INF/jsp/");
	 * resolver.setSuffix(".jsp"); return resolver; }
	 */
	
	//跨域CORS设置
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("GET","POST","PUT", "DELETE")
		//.allowedHeaders("header1", "header2", "header3")
		//.exposedHeaders("header1", "header2")
		.allowCredentials(true).maxAge(3600);
		// Add more mappings...
		System.out.println("跨域访问设置。。。");
	}
	//启用Spring mvc 启用@MatrixVariable
	//XML方式：<mvc:annotation-driven enable-matrix-variables="true"/>
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer){
	    UrlPathHelper urlPathHelper = new UrlPathHelper();
	    urlPathHelper.setRemoveSemicolonContent(false);
	    configurer.setUrlPathHelper(urlPathHelper);
	}
	
	

}
