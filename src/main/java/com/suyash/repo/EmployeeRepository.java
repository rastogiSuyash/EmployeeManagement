package com.suyash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suyash.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
