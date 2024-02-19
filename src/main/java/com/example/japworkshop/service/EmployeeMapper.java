package com.example.japworkshop.service;

import com.example.japworkshop.model.dto.DepartmentDto;
import com.example.japworkshop.model.dto.EmployeeDto;
import com.example.japworkshop.model.entity.Department;
import com.example.japworkshop.model.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    public EmployeeDto toDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setSalary(employee.getSalary());
        dto.setContractEnd(dto.getContractEnd());
        return dto;
    }

    public Employee toEntity(EmployeeDto dto){
        Employee entity = new Employee();
        entity.setFirstName(entity.getFirstName());
        entity.setLastName(entity.getLastName());
        entity.setSalary(entity.getSalary());
        entity.setDepartment(entity.getDepartment());
        entity.setSupervisor(entity.getSupervisor());
        entity.setEntryCard(entity.getEntryCard());
        entity.setContractEnd(entity.getContractEnd());
        return entity;
    }



}
