package com.example.contentstest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ContentsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentsTestApplication.class, args);
//		Runnable logRunnable = () -> log.info("log test {}", LocalDateTime.now());
//		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//		executor.scheduleAtFixedRate(logRunnable, 0, 500, TimeUnit.MILLISECONDS);
	}

}
