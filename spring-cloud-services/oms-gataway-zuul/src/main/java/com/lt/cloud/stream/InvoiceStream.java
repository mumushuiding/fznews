package com.lt.cloud.stream;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

import com.lt.cloud.pojo.Invoice;

import reactor.core.publisher.Flux;

@Component
@EnableBinding(InvoiceProcessor.class)
public class InvoiceStream {
	@Autowired 
	private InvoiceProcessor invoiceChannel;
	@StreamListener(InvoiceProcessor.INPUT)
	public void log4Invoice(){
		Flux<Invoice> flux=Flux.create(sink -> {
			MessageHandler handler= message -> sink.next((Invoice)message.getPayload());
			invoiceChannel.input().subscribe(handler);
			sink.onCancel(()->invoiceChannel.input().unsubscribe(handler));
			
		});
		flux.subscribe(System.out::println);
	}
}
