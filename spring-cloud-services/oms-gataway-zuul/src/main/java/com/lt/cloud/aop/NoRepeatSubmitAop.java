package com.lt.cloud.aop;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.cache.Cache;
import com.lt.cloud.annotation.NoRepeatSubmit;

@Aspect
@Component
public class NoRepeatSubmitAop{
	@Autowired
	private Cache<String, Integer> cache;
	@Around("execution(* com.lt..*Controller.*(..)) && @annotation(nrs)")
	public Object around(ProceedingJoinPoint pjp,NoRepeatSubmit nrs) {
		System.out.println("*************************2秒内禁止重复提交******************************");
		ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=attributes.getRequest();
		String key=getIp(request)+"-"+request.getServletPath();
		try {
			if(cache.getIfPresent(key)==null) {// 如果缓存中有这个url视为重复提交
				System.err.println("key:"+key);
				Object o=pjp.proceed();
				cache.put(key, 0);
				return o;
			}else {
				 return "{\"code\":200,\"message\":\"不要重复提交!\"}";
			}
		} catch (Throwable e) {
			
			e.printStackTrace();
			 return "{\"code\":500,\"message\":\"操作失败!\"}";
			
		}
	}
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
		ip = "127.0.0.1";
		}
		return ip;
    }
}
