package myspring;

import java.util.List;

public interface BeanFactory {
    public Object getBean(String name);
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
