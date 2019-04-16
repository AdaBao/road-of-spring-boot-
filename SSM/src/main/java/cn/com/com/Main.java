package cn.com.com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.MyMvcConfig;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
		AsyncTaskService asyncTaskService=context.getBean(AsyncTaskService.class);
		asyncTaskService.task1();
		asyncTaskService.task2();
		context.close();

	}

}
