package cn.com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		long startTime=System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		System.out.println("开始时间:"+startTime);
		return true;
	}
	
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		long endTime=System.currentTimeMillis();
		long startTime=(Long)request.getAttribute("startTime");
		System.out.println("结束时间:"+endTime);
		System.out.println("处理时间:"+(endTime-startTime));
		
	}
}
