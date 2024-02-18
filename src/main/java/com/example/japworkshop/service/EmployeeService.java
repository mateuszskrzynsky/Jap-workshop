package com.example.japworkshop.service;

import com.example.japworkshop.model.dto.NewEmployeeReq;
import com.example.japworkshop.model.entity.Employee;
import com.example.japworkshop.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(NewEmployeeReq newEmployeeReq) {
        Employee newEmployeeEntity=new Employee();
        newEmployeeEntity.setFirstName(newEmployeeReq.getFirstName());
        newEmployeeEntity.setLastName(newEmployeeReq.getLastName());
        newEmployeeEntity.setSalary(newEmployeeReq.getSalary());
        newEmployeeEntity.setContractEnd(newEmployeeReq.getContractEnd());
        return employeeRepository.save(newEmployeeEntity);
    }

}
