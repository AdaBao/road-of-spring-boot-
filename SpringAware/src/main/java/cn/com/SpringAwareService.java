package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class SpringAwareService implements BeanNameAware,ResourceLoaderAware{
    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String string) {
        this.beanName=string;
    }

    @Override
    public void setResourceLoader(ResourceLoader rl) {
        this.resourceLoader=rl;
    }
    
    public void printResult(){
        System.out.println("BeanName:"+this.beanName);
        Resource resource=this.resourceLoader.getResource("classpath:cn/com/test.txt");
        try {
            InputStream inputStream=resource.getInputStream();
            Reader reader=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(reader);
           System.out.println("resource content:"+br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(SpringAwareService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

