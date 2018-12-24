package com.lt.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.PublishSubscribeChannel;


import com.spring.cloud.stream.transaction.interceptor.GlobalMessageWrapperInterceptor;
@Configuration
public class StreamConfig {

	@Bean
	public PublishSubscribeChannel channel() {
		PublishSubscribeChannel channel=new PublishSubscribeChannel();
		channel.setApplySequence(true);//用于aggretor
		channel.addInterceptor(new GlobalMessageWrapperInterceptor());
		return channel;
	}

}
