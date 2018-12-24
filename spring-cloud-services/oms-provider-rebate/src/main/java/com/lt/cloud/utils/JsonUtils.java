package com.lt.cloud.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import com.google.gson.Gson;

public class JsonUtils {
	private static Gson gson;
	public static Gson getGson(){
		if(gson==null) return new Gson();
		return gson;
	}
	public static String formatDataForPagination(String jsonString,long total,int pageIndex,int pageSize){
		StringBuffer stringBuffer=new StringBuffer("{}");
		stringBuffer.insert(1,"\"total\":"+total+",\"page\":"+pageIndex+",\"pageSize\":"+pageSize+",\"rows\":"+jsonString);
		return stringBuffer.toString();
	}
	public static String formatDataForEasyUIForPagination(String jsonString,long total,int pageIndex,int pageSize){
		StringBuffer stringBuffer=new StringBuffer("{}");
		stringBuffer.insert(1,"\"total\":"+total+",\"page\":"+pageIndex+",\"pageSize\":"+pageSize+",\"rows\":"+jsonString);
		return stringBuffer.toString();
	}
	public static String formatPageForPagination(Page page) {
		
		return formatDataForPagination(getGson().toJson(page.getContent()), page.getTotalElements(), page.getPageable().getPageNumber()+1,page.getPageable().getPageSize());
	}

	
}

