package cn.com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		
		if(ex instanceof CustomException) {
			ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("message", ex.getMessage());//model
	        modelAndView.setViewName("error");//view
	        
	        return modelAndView;
		}
		return null;
	}

}
