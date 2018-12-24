package com.lt.cloud;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.codingapi.tx.netty.handler.TransactionHandler;
import com.codingapi.tx.springcloud.service.impl.ModelNameServiceImpl;
import com.lt.cloud.filter.PreRequestLogFilter;
import com.lt.cloud.stream.AdvProcessor;
import com.spring.cloud.stream.transaction.interceptor.GlobalMessageWrapperInterceptor;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy//该代理使用Ribbon来定位注册在Eureka Server中的服务，整合了Hystrix
@EnableFeignClients
@EnableBinding(value= {AdvProcessor.class})
public class OmsGatawayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsGatawayZuulApplication.class, args);
	}
	@Bean
	public PreRequestLogFilter preRequestLogFilter() {
		return new PreRequestLogFilter();
	}
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config=new CorsConfiguration();
		config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
      
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
	}
}
