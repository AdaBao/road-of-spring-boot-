package cn.com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//setter 方法实例化bean
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans1.xml");
		Action action=(Action)ctx.getBean("action_name");
		action.execute();
		ctx.close();
	}

}
