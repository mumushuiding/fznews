package com.spring.cloud.stream.transaction.interceptor;

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;
public class GlobalMessageWrapperInterceptor implements ChannelInterceptor  {

	@Override
	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
		System.out.println("*************发送前拦截**************");
		IntegrationMessageHeaderAccessor mAccessor=new IntegrationMessageHeaderAccessor(message);
	
		System.out.println(mAccessor.getCorrelationId());
		
		System.out.println(message.getHeaders().getReplyChannel());
		System.out.println(message.getPayload());
		System.out.println(message.getHeaders());
	}

}
