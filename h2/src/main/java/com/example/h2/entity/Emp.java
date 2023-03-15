package com.example.h2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
//orm
@Entity
//USED FOR MAPPING TABLE IF NAME IS NOT SAME THEN PROVIDE BELOW LINE OTHERWISE ITS IS FINE TO WORRK WITH IT AS IS.
@Table(name="Emp")
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "NAME SHOULD NOT BE NULL" )
	private String name;
	
	@Min(8)
	@Max(10)
	private Integer salary;
	private String status;
	
	public Emp() {}
	public Emp(Integer id, String name, Integer salary, String status) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + ", status=" + status + "]";
	}
	
	
}
