package com.example.japworkshop.service;

import com.example.japworkshop.exception.NoSuchClientException;
import com.example.japworkshop.model.dto.EmployeeDto;
import com.example.japworkshop.model.dto.NewEmployeeReq;
import com.example.japworkshop.model.entity.Employee;
import com.example.japworkshop.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public Employee addEmployee(NewEmployeeReq newEmployeeReq) {
        Employee newEmployeeEntity=new Employee();
        newEmployeeEntity.setFirstName(newEmployeeReq.getFirstName());
        newEmployeeEntity.setLastName(newEmployeeReq.getLastName());
        newEmployeeEntity.setSalary(newEmployeeReq.getSalary());
        newEmployeeEntity.setContractEnd(newEmployeeReq.getContractEnd());
        return employeeRepository.save(newEmployeeEntity);
    }

    public List<EmployeeDto> findEmployeesByLastName(String lastName) {
        List<Employee> employees = employeeRepository.findByLastName(lastName);
        if (employees.isEmpty()) {
            throw new NoSuchClientException("No employee found with last name: " + lastName);
        }

        return employees.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }
    @Transactional
    public List<EmployeeDto> findBySalaryRange(BigDecimal minSalary, BigDecimal maxSalary) {
        List<Employee> employees = employeeRepository.findBySalaryRange(minSalary, maxSalary);
        return employees.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

}
