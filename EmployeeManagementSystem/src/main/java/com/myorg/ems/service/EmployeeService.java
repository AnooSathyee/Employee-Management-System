package com.myorg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myorg.ems.model.Employee;
import com.myorg.ems.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	//getEmployeeList()
	public List<Employee> listAll(){
		return repo.findAll();
	}
	
	//addEmployee()
	public void save(Employee employee) {
		repo.save(employee);
	}
	
	//getEmployee()
	public Employee get(int id) {
		return repo.findById(id).get();
	}
	
	//deleteEmployee()
	public void delete(int id) {
		repo.deleteById(id);
	}

}