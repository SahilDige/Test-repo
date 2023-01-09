package com.example.h2.service;

import java.lang.System.Logger;
import java.util.List;
import java.util.Optional;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2.entity.Emp;
import com.example.h2.exception.EmpException;
import com.example.h2.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService{

	
	@Autowired EmpRepository empRepository;
	
	@Override
	public Emp addEmp(Emp emp) {
		try {	return empRepository.save(emp);}
		catch(Exception e) 
		{
			
			throw new EmpException("ERROR OCCURED WHILE ENTERING DATA");}
	
	}

	@Override
	public Emp getEmpById(Integer id) {
		try {	
			Optional<Emp> findById = empRepository.findById(id);
			return findById.get();}
		catch(Exception e) 
		{throw new EmpException("ERROR OCCURED WHILE GETTING  NAME AS DATA");}
		
	}

	@Override
	public Emp getEmpByName(String name) {
		try {	
		return  empRepository.findByName(name);}
		catch(Exception e) 
		{throw new EmpException("ERROR OCCURED WHILE GETTING  NAME AS DATA");}

	}

	@Override
	public List<Emp> getAllEmp() {
		try {	
			return  empRepository.findAllEmp();}
			catch(Exception e) 
			{throw new EmpException("ERROR OCCURED WHILE GETTING  ALL  DATA");}
		
	}



}
