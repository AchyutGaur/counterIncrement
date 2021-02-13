package com.example.multiple.service;

import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

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
	@Transactional
	public CompletableFuture<Counter> increaseCounter() {
		Counter newCount;
		synchronized (lock) {

			System.out.println("Thread name " + Thread.currentThread().getName());
			newCount = new Counter();
				Counter count = counterRepository.findFirstByOrderByCounterDesc();
				System.out.println("Counter value: " + count.getCounter());
				int rowUpdated = counterRepository.updateCounterById(newCount.increment(count), count.getCounter());

				System.out.println("Row updated: " + rowUpdated);
		}
		return CompletableFuture.completedFuture(newCount);
	}
}
