package cn.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//实例工厂方式实例化bean
public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans4.xml");
		Action action=context.getBean(Action.class);
		action.execute();
		context.close();
	}

}
