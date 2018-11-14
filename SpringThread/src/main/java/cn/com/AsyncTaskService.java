package cn.com;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
	@Async
	public void print1() {
		System.out.println("text1");
	}
	
	@Async
	public void print2() {
		System.out.println("text2");
	}

}
