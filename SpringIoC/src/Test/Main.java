package Test;

import myspring.BeanFactory;
import myspring.BeanFactoryImpl;

public class Main {
    public static void main(String[] args){

        String xmlFilePath = "myspring.xml";
        BeanFactory beanFactory = new BeanFactoryImpl(xmlFilePath);
        SayHello sayHello =(SayHello) beanFactory.getBean("sayHello");
        sayHello.sayHello();

        Family family = (Family) beanFactory.getBean("family");
        family.print();
    }
}
