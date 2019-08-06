package com.neu.mvcweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Root Context配置类 项目基本IoC配置类
@Configuration
@ComponentScan(basePackages = {"com.neu.mvcweb"})
public class AppRootConfig {
	
	

}
