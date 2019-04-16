package cn.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//静态工厂方式实例化bean
public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans3.xml");
		Action action=context.getBean(Action.class);
		action.execute();
		context.close();

	}

}
