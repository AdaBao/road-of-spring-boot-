package cn.com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		AsyncTaskService  service=context.getBean(AsyncTaskService.class);
		
		for(int i=0; i<10; i++)
		{
			service.print1();
			service.print2();
		}
		
		context.close();

	}

}
