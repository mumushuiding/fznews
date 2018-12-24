package com.lt.cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface InvoiceProcessor {
	String INPUT="invoiceInput";
	String OUTPUT="invoiceOutput";
	
	@Input(InvoiceProcessor.INPUT)
	SubscribableChannel input();
	@Output(InvoiceProcessor.OUTPUT)
	MessageChannel output();
}
