package com.example.multiple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multiple.entity.Counter;
import com.example.multiple.service.CounterService;

@RestController
@RequestMapping(value = "api/counter")
public class Controller {
	
	@Autowired
	CounterService counterService;
	
	@PutMapping(value = "increase")
	public ResponseEntity<Counter> increaseCounter(){
		counterService.increaseCounter();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "hello")
	public String helloWorld() {
		return "Hello_World!!!";
	}
	
}
