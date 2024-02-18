package com.example.japworkshop.service;

import com.example.japworkshop.exception.ObjectNotFoundException;
import com.example.japworkshop.model.entity.Department;
import com.example.japworkshop.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department findDepartmentByName(String name){
        Optional<Department> optDepatment = departmentRepository.findByName(name);

        if (optDepatment.isPresent()){
            return optDepatment.get();
        }
        return null;
    }

    public List<Department> findDepartmentsByCity(String city){
        List<Department> departments = departmentRepository.findByCity(city);
        if (departments.isEmpty()){
            throw new ObjectNotFoundException(HttpStatus.NOT_FOUND);
        }
        return departmentRepository.findAllByAddress_City(city);
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department, Long id){
        Department upUepartment = departmentRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(HttpStatus.NOT_FOUND));
        department.setName(department.getName());
        department.setAddress(department.getAddress());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id){
        Department delDepartment = departmentRepository.findById(id)
                .orElseThrow(()->new ObjectNotFoundException(HttpStatus.NOT_FOUND));
        departmentRepository.delete(delDepartment);
    }
}