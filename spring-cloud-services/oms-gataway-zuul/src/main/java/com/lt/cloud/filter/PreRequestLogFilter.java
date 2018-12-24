package com.lt.cloud.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreRequestLogFilter extends ZuulFilter{
	private static final Logger LOGGER=LoggerFactory.getLogger(PreRequestLogFilter.class);
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		PreRequestLogFilter.LOGGER.info(String.format("send %s request to %s",
				request.getMethod(),request.getRequestURL().toString()));
		System.out.println("**************filter****************");
	
		return null;
	}

	@Override
	public boolean shouldFilter() {
		
		return true;//表示过滤器是否执行
	}

	@Override
	public int filterOrder() {
		
		return 1;//过滤器执行顺序
	}

	@Override
	public String filterType() {
		
		return "pre";//返回过滤的类型;有pre,route,post,error等
	}

}
