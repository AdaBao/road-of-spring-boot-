package cn.com;

import static org.hamcrest.CoreMatchers.nullValue;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	@Pointcut("@annotation(cn.com.Action)")
	public void annotationPointCut() {}
	
	@Pointcut("@annotation(cn.com.Action1)")
	public void annotationPointCut1() {}
	
	@Pointcut("@annotation(cn.com.Action2)")
	public void annotationPointCut2() {}
	
	@Before("annotationPointCut()")
	public void before(JoinPoint joinPoint) {
		/*MethodSignature signature=(MethodSignature) joinPoint.getSignature();
		Method method=signature.getMethod();
		Action action=method.getAnnotation(Action.class);
		System.out.println("执行"+method.getName()+"函数,功能是"+action.name());*/
		
		System.out.println("before");
	}
	
	
	
	@Around("annotationPointCut2()")
	public Object around(ProceedingJoinPoint pjp) {
		System.out.println("around");
		try {
			Object object=pjp.proceed();//执行before建言和控制器中的方法
			System.out.println(object instanceof List);
			return object;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@After("annotationPointCut1()")
	public void after(JoinPoint joinPoint) {
		System.out.println("after");
	}
	
	

}
