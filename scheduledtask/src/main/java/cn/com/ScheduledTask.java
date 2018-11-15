package cn.com;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {
    @Scheduled(fixedRate = 1000)
    public void print(){
        System.out.println("每隔一秒打印此行");
    }
}
