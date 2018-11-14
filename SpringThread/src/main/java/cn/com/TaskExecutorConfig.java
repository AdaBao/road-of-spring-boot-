package cn.com;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("cn.com")
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer{

	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
		ThreadPoolTaskExecutor  taskExecutor=new ThreadPoolTaskExecutor();
		/*
		 * ThreadPoolExecutor的corePoolSize和maximumPoolSize
			按照JDK文档的描述，
			如果池中的实际线程数小于corePoolSize,无论是否其中有空闲的线程，都会给新的任务产生新的线程
			如果池中的线程数>corePoolSize and <maximumPoolSize,而又有空闲线程，就给新任务使用空闲线程，如没有空闲线程，则产生新线程
			如果池中的线程数＝maximumPoolSize，则有空闲线程使用空闲线程，否则新任务放入workQueue。（线程的空闲只有在workQueue中不再有任务时才成立）
		 * */
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.initialize();
		return taskExecutor;
		
	}

}
