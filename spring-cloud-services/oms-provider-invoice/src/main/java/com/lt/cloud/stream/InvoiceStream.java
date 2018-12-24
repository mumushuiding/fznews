package com.lt.cloud.stream;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import com.lt.cloud.pojo.Invoice;

import reactor.core.publisher.Flux;

@EnableBinding(InvoiceProcessor.class)
@EnableAutoConfiguration
public class InvoiceStream {
	@Autowired 
	private InvoiceProcessor invoiceChannel;
//	@StreamListener(InvoiceProcessor.INPUT)
//	public void log4Invoice(Flux<Invoice> input){
//		input.subscribe(new Consumer<Invoice>() {
//
//			@Override
//			public void accept(Invoice t) {
//				System.out.println("log:"+t);
//				
//			}
//		});
//	}
	@StreamListener(InvoiceProcessor.INPUT)
	public void log4Invoice2(){
		Flux<Invoice> flux=Flux.create(sink -> {
			MessageHandler handler= message -> sink.next((Invoice)message.getPayload());
			invoiceChannel.input().subscribe(handler);
			sink.onCancel(()->invoiceChannel.input().unsubscribe(handler));
			
		});
		flux.subscribe(e->{
			System.out.println("log2:"+e);
		});
	}

}
