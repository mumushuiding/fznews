package com.lt.cloud.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SqlTimeConsume {
	private static final String DASH_LINE = "===================================";
	private static final String NEXT_LINE = "\n";
	@Around("execution(public * com.lt.cloud.service..*.select*(..))")
	public Object process(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(DASH_LINE);
		Date start=new Date();
		System.out.println("开始查询:");
		
		Object object = pjp.proceed(pjp.getArgs());
		Date end=new Date();
		System.out.println(DASH_LINE);
		System.out.println("查询结束-耗时："+(end.getTime()-start.getTime()));
		return object;
	}

	
}
