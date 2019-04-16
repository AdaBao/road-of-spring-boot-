package cn.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//通过构造函数实例化bean
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans2.xml");
		Action1 action1=context.getBean(Action1.class);
		action1.execute();
		context.close();
	}

}
