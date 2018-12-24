package com.lt.cloud.advice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.netflix.hystrix.exception.HystrixRuntimeException;
//@RestControllerAdvice
public class MyControllerAdvice {
	@ExceptionHandler(value=HystrixRuntimeException.class)
	public String balanceHandler(HystrixRuntimeException ex) {
		ex.printStackTrace();
		throw new RuntimeException("连接超时，操作失败");
	}
}
