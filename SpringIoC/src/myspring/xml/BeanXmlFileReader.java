package myspring.xml;

import myspring.BeanDefinition;
import myspring.BeanFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

public class BeanXmlFileReader {
    private String xmlFilePath;
    public BeanXmlFileReader(String xmlFilePath){
        this.xmlFilePath = xmlFilePath;
    }

    public void parseXmlFile(BeanFactory beanFactory){
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource(xmlFilePath);

        File xmlFile = new File(url.getFile());
        SAXReader saxReader = new SAXReader();
        try {

            Document document = saxReader.read(xmlFile);
            Element rootElement = document.getRootElement();
            List<Element> elementList = rootElement.elements();

            int beanQuantity = elementList.size();
            int [][] adjMatrix = new int[beanQuantity][beanQuantity];
            for(int i=0; i<beanQuantity; i++){
                for(int j=0; j<beanQuantity; j++)
                    adjMatrix[i][j] = 0;
            }

            Map<String, Integer> beanMap = new HashMap<>();
            String[] beanNameArr = new String[beanQuantity];
            int index = 0;
            for(Element element:elementList){
                String beanName = element.attributeValue("name");
                beanMap.put(beanName,index);
                beanNameArr[index] = beanName;
                index++;
            }


            Map<Integer, BeanDefinition> beanDefinitionMap = new HashMap<>();
            index = 0;
            for(Element element:elementList){
                String beanName = element.attributeValue("name");
                String className = element.attributeValue("class");
                Class beanClass = Class.forName(className);
                Map<String, Object> propertyValues = new HashMap<>();
                Object bean = null;
                BeanDefinition beanDefinition = new BeanDefinition(className,beanClass,bean,propertyValues);

                beanDefinitionMap.put(index,beanDefinition);
                index++;

                List<Element> propertyEleList = element.elements();
                for(Element propertyEle:propertyEleList){

                    String propertyName = propertyEle.attributeValue("name");
                    String propertyValue = propertyEle.attributeValue("value");
                    String ref = propertyEle.attributeValue("ref");


                    if(ref != null && propertyValue == null ){
                        propertyValues.put(propertyName,null);
                        int index1 = beanMap.get(beanName);
                        int index2 = beanMap.get(ref);
                        adjMatrix[index1][index2] = 1;
                    }else if(ref == null && propertyValue != null){
                        propertyValues.put(propertyName,propertyValue);
                    }
                }
            }

            //解决依赖
            boolean [] solved = new boolean[beanQuantity];
            for(int i=0; i<solved.length; i++){
                solved[i] = false;
            }


            int currentObj  = 0;
            while((currentObj = findNoDependency(adjMatrix,beanQuantity, solved))!=-1){
                solved[currentObj] = true;
                for(int i=0; i<beanQuantity; i++){
                    adjMatrix[i][currentObj] = 0;
                }

                BeanDefinition beanDefinition = beanDefinitionMap.get(currentObj);
                Map<String, Object> propertyValues = beanDefinition.getPropertyValues();

               Set<Map.Entry<String, Object>> entries = propertyValues.entrySet();
               Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
               while(iterator.hasNext()){
                   Map.Entry<String, Object> entry = iterator.next();
                   String name = entry.getKey();
                   Object value = entry.getValue();
                   if(value == null){
                       int beanIndex = beanMap.get(name);
                       BeanDefinition beanDefinition1 = beanDefinitionMap.get(beanIndex);
                       value = beanDefinition1.getBean();
                       propertyValues.put(name,value);
                   }
               }

                Class beanClass = beanDefinition.getBeanClass();
                Field[] fields = beanClass.getDeclaredFields();
                Object obj = beanClass.newInstance();

                for(int i=0; i<fields.length; i++){
                    Field f = fields[i];
                    f.setAccessible(true);
                    String fName = f.getName();
                    Object object = propertyValues.get(fName);
                   // if(f.getType().getName().equals("int")
                    if(f.getType().isPrimitive()){
                        {
                            Integer integer = new Integer((String)object);
                            f.set(obj,integer);
                        }
                    }else
                    f.set(obj,object);
                }
                beanDefinition.setBean(obj);
                beanFactory.registerBeanDefinition(beanNameArr[currentObj],beanDefinition);

            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    private int findNoDependency(int[][] adjMatrix, int n, boolean[] solved){
        for(int i=0; i<n; i++) {
            if(solved[i]) continue;
            boolean tag = false;
            for (int j = i + 1; j < n; j++) {
                if(adjMatrix[i][j] == 1)
                {
                    tag = true;
                    break;
                }
            }

            if(!tag)
            {
                return i;
            }
        }
        return -1;
    }



}
