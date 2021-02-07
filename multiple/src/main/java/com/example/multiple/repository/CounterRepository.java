package com.example.multiple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.multiple.entity.Counter;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Integer>{
	
	public Counter findFirstByOrderByCounterDesc();

}
