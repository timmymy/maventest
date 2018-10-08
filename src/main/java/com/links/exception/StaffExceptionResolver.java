package com.links.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class StaffExceptionResolver implements HandlerExceptionResolver {
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		StaffException staffException = null;
		if (ex instanceof StaffException) {
			staffException = (StaffException) ex;
		}else {
			staffException = new StaffException("程序员正在努力寻找问题。。。。。");
		}
		String msg = staffException.getMessage();
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("msg", msg);
		return mv;
	}

}
