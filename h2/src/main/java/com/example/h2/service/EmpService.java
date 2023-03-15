package com.example.h2.service;
//interface - used data abstraction -- to show thing we need to visualize end user.
import java.util.List;

import com.example.h2.entity.Emp;

public interface EmpService {
	public Emp addEmp(Emp emp);
	public Emp getEmpById(Integer id);
	public Emp getEmpByName(String name);
	public List<Emp> getAllEmp();

}
