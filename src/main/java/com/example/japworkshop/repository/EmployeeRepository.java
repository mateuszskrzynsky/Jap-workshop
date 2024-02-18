package com.example.japworkshop.repository;

import com.example.japworkshop.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {



}
