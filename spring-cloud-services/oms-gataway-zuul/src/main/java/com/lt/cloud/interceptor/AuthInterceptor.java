package com.lt.cloud.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lt.cloud.pojo.User;


public class AuthInterceptor implements HandlerInterceptor{
	
   //不拦截请求
	private List<String> getIgnoreUri(){
		List<String> result=new ArrayList<String>();
		result.add("/user/loginForm");
		result.add("/user/login");
		result.add("/index");
		
		
		return result;
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		
		boolean flag=false;
		//获取请求的路径进行判断
		String servletPath=request.getServletPath();
		
		for(String s:this.getIgnoreUri()){
			if(servletPath.contains(s)){
				flag=true;
				break;
			}
		}
		
		//拦截请求
		if(!flag){
			User user=(User) request.getSession().getAttribute("sysuser");
			if(user==null){
				request.getRequestDispatcher("/user/loginForm").forward(request, response);
			}
		}
		//获取用户所有的权限
      
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

}
