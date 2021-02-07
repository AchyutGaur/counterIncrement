package com.example.multiple.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "counter")
@Data
public class Counter {

	@Id
	@Column(name = "counter")
	int counter;
}
