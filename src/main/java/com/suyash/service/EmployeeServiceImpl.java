package com.suyash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyash.model.Employee;
import com.suyash.repo.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}


	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepo.save(employee);
	}


	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional =employeeRepo.findById(id);
		Employee emp=null;
		if(optional.isPresent()) {
			emp=optional.get();
		}
		else {
			throw new RuntimeException("employee not found: "+id);
		}
		return emp;
	}


	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		this.employeeRepo.deleteById(id);
		
	}

}
