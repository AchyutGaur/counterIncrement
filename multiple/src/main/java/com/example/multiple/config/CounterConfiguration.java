package com.example.multiple.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class CounterConfiguration {

	@Bean(name = "taskExecutor")
	public Executor taskExecutor() {
		final ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(5);
		taskExecutor.setThreadNamePrefix("Counter-");
		taskExecutor.initialize();
		return taskExecutor;
		
	}
}
