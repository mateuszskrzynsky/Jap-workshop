package com.example.japworkshop.service;

import com.example.japworkshop.model.dto.DepartmentDto;
import com.example.japworkshop.model.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentDto toDto(Department entity){
        DepartmentDto dto = new DepartmentDto();
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());

        return dto;
    }

    public Department toEntity(DepartmentDto dto){
        Department entity = new Department();
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());

        return entity;
    }
}
