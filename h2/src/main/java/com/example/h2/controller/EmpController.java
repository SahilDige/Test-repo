package com.example.h2.controller;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.domain.EmpResponse;
import com.example.h2.entity.Emp;
import com.example.h2.exception.ErrorResponse;
import com.example.h2.service.EmpService;

import jakarta.validation.Valid;

//@Responsebody OBJECT TO BE SEND IN HTTP RESONSE if not use then just initializes controller and the inside methods will be invoked
//not able to get response back from the controller,client will not be able to get object

@RestController
@RequestMapping("/emp")

//1>it is managed by spring 
//2>acts as controller in MVC application {vcm}
//3>to make class as rest controller to  handle rest web service request in spring mvc application
//@controller+@Responsebody=@Restconttroller
//when we send domian specific pojos REst controller used ,to convert value object to json object to put in body of http request and response
//to recieve rest url request , {json format}
//@RequestMapping("/demo")
//provides  uri path for the controller
//to map the whole controller as incase of  api end point
public class EmpController {

	@Autowired
	//1>if type has multiple implementation class than requires @Qualifier otherwise it's confused what bean to actually inject for class/
		//i.e type based injection
		//2>otherwise use name based injection without qualifier and just bean name{uniquely inject bean}.
		//object to be created by spring framework and inject in the current class
		//to manage the instance creation of the component,class by the bean manager .
		
	
	EmpService empService;
	
	@GetMapping("/{id}")
	//provides  uri path for the api end point
	
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
	public ResponseEntity<Object> addEmp(@Valid @RequestBody Emp emp, BindingResult bindingResult ) {
		
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(),HttpStatus.BAD_REQUEST );
					//"Invalid Request",HttpStatus.BAD_REQUEST);
		}	
		
//	@PostMapping("/emp")
//	public ResponseEntity<Object> addEmp( @RequestBody Emp emp  ) {
			
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
