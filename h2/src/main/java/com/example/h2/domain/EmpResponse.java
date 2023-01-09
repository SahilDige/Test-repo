package com.example.h2.domain;

import java.io.Serializable;

public class EmpResponse implements Serializable {
	private static final long serialVersionUID=423523451L;
	private Object empResponse;
	private String messsage;
	
	public EmpResponse() {}
	
	public EmpResponse(Object empResponse, String messsage) {
		super();
		this.empResponse = empResponse;
		this.messsage = messsage;
	}

	public Object getEmpResponse() {
		return empResponse;
	}

	public void setEmpResponse(Object empResponse) {
		this.empResponse = empResponse;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	
	

}
