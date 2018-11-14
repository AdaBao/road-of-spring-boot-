package cn.com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AwareConfig.class);
	        SpringAwareService  awareService=context.getBean(SpringAwareService.class);
	        awareService.printResult();
	        context.close();

	}

}
