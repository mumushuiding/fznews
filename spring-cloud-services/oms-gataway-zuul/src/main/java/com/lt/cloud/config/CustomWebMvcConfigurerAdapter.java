package com.lt.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lt.cloud.interceptor.AuthInterceptor;

@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{
	
	
	@Bean
	AuthInterceptor authInterceptor(){          

		return new AuthInterceptor();
	}
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	       //registry.addInterceptor(authInterceptor()).addPathPatterns("/**");  //对来自/user/** 这个链接来的请求进行拦截
	      
	    }

}
