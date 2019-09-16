package myspring;

import myspring.xml.BeanXmlFileReader;

import java.util.HashMap;
import java.util.Map;

public class BeanFactoryImpl implements  BeanFactory {
    private Map<String,BeanDefinition> map = new HashMap<>();

    public BeanFactoryImpl (String xmlFilePath){
        new BeanXmlFileReader(xmlFilePath).parseXmlFile(this);
    }
    @Override
    public Object getBean(String name) {
        BeanDefinition beanDefinition = map.get(name);
        return beanDefinition.getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        map.put(name,beanDefinition);
    }
}
