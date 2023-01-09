package com.example.h2.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.domain.EmpResponse;
import com.example.h2.entity.Emp;
import com.example.h2.exception.ErrorResponse;
import com.example.h2.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService empService;
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<EmpResponse> getEmpById(@PathVariable("id") Integer id) {
		EmpResponse res = new EmpResponse();
		Emp emp = empService.getEmpById(id);
		res.setEmpResponse(emp);
		res.setMesssage("Success");
		return new ResponseEntity<EmpResponse>(res,HttpStatus.OK);
	}
	
	@GetMapping("/empByName")
	public ResponseEntity<EmpResponse> getEmpByName(@RequestParam String name) {
		EmpResponse res = new EmpResponse();
		Emp emp = empService.getEmpByName(name);
		res.setEmpResponse(emp);
		res.setMesssage("Sucess");
		return new ResponseEntity<EmpResponse>(res,HttpStatus.OK);
	}
	
	@GetMapping("/allEmp")
	public ResponseEntity<EmpResponse> getAllEmp() {
		EmpResponse res = new EmpResponse();
		List<Emp> emp = empService.getAllEmp();
		res.setEmpResponse(emp);
		res.setMesssage("Sucess");
		return new ResponseEntity<EmpResponse>(res,HttpStatus.OK);
	}
	
	@PostMapping("/emp")
	public ResponseEntity<Object> addEmp(@RequestBody Emp emp) {
		EmpResponse res = new EmpResponse();
		if(emp == null)
		{
			return new ResponseEntity<Object>("Invalid Request",HttpStatus.BAD_REQUEST);
		}
		
		Emp addemp = empService.addEmp(emp);
		res.setEmpResponse(addemp);
		res.setMesssage("Sucess");
		return new ResponseEntity<Object>("succesfully entered employee",HttpStatus.OK);
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	
	public ErrorResponse myException(RuntimeException e)
	{
		return new ErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST.value());
	}
	
}
