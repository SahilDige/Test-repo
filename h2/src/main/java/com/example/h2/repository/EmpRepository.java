package com.example.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.h2.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp,Integer>{
public Emp findByName(String string);

@Query(value="select id,name,salary,status From Emp",nativeQuery=true)
public List<Emp> findAllEmp();
}
 

