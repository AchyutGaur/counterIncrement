package com.example.multiple.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.multiple.entity.Counter;
import com.example.multiple.repository.CounterRepository;

@Service
public class CounterService {

	private static final Object lock = new Object();

	@Autowired
	CounterRepository counterRepository;

	@Async
	public CompletableFuture<Counter> increaseCounter() {
		Counter newCount = new Counter();
		synchronized (lock) {
			if (counterRepository.count() == 0) {
				newCount.setCounter(0);
				counterRepository.save(newCount);
			} else {
				Counter count = counterRepository.findFirstByOrderByCounterDesc();
				newCount.setCounter(count.getCounter() + 1);
				counterRepository.save(newCount);
			}

		}
		return CompletableFuture.completedFuture(newCount);
	}
}
