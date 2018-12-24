package com.lt.cloud.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface AdvProcessor {
	String OUTPUT_ADV="outputAdv";
	@Output(AdvProcessor.OUTPUT_ADV)
	SubscribableChannel outputAdv();
}
