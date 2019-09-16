package myspring;

import myspring.io.Resource;
import myspring.io.ResourceLoader;

import java.util.List;
import java.util.Map;

public class BeanDefinition {
    private String className;
    private Class beanClass;
    private Object bean;
    private Map<String, Object> propertyValues;

    public BeanDefinition(String className, Class beanClass, Object bean, Map<String, Object> propertyValues){
        this.className = className;
        this.beanClass = beanClass;
        this.bean = bean;
        this.propertyValues = propertyValues;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Map<String, Object> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(Map<String, Object> propertyValues) {
        this.propertyValues = propertyValues;
    }
}
