package cn.com.com;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
	@Async
	public void task1() {
		for(int i=0; i<10; i++) {
			System.out.println("task1_"+i);
		}
	}
	@Async
	public void task2() {
		for(int i=0; i<10; i++) {
			System.out.println("task2_"+i);
		}
	}
}
