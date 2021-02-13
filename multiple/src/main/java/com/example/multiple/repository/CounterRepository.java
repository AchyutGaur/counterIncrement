package com.example.multiple.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.multiple.entity.Counter;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Integer>{
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public Counter findFirstByOrderByCounterDesc();
	
	@Modifying
	@Query("update Counter c set c.counter=:value where c.counter=:id")
	public int updateCounterById(@Param("value")Integer value,@Param("id")Integer id);

}
