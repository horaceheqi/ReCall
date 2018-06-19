package com.cyou.bi.ms.ds.recall.common;

import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;



public class JsonService {
	private static Gson gson;
	private static final Logger logger = LoggerFactory
			.getLogger(JsonService.class);

	static {
		gson = new Gson();
	}

	public static Object getBean(String str, Class clazz) {
		if (logger.isDebugEnabled()) {
			logger.debug("get bean,json String:" + str + " class:"
					+ clazz.toString());
		}
		return gson.fromJson(str, clazz);
	}

	public static String toString(Object bean) {
		String str = gson.toJson(bean);
		if (logger.isDebugEnabled()) {
			logger.debug("to beab,json String:" + str + " Bean:"
					+ bean.toString());
		}
		return str;
	}
	public static String toString(Object bean,Type type) {
		String str = gson.toJson(bean,type);
		if (logger.isDebugEnabled()) {
			logger.debug("to beab,json String:" + str + " Bean:"
					+ bean.toString());
		}
		return str;
	}
 public static void main(String[] agrs){
	 
	 
 }
}
