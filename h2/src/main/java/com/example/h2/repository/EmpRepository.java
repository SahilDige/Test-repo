package com.example.h2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.h2.entity.Emp;

@Repository
//IF USED @COMPONENT IN PLACE OF @REPOSITORY WILL SHOW ALL THE PLATFORM SPECIFIC EXCEPTION  ,BUT IF USED @REPOSITORY NEED  TO BE HANDELED AT SERVICE LAYER 
//NEED NOT TO MODIFY THE SERVICE LAYER
//PLATFORM EXCEPTION INTO SPRING FRAMEWORK DATA ACCES EXCEPTION

public interface EmpRepository extends JpaRepository<Emp,Integer>{
public Optional<Emp> findByName(String string);

@Query(value="select id,name,salary,status From Emp",nativeQuery=true)
public List<Emp> findAllEmp();
}
 

