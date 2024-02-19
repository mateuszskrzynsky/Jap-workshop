package com.example.japworkshop.controller;

import com.example.japworkshop.model.dto.DepartmentDto;
import com.example.japworkshop.model.entity.Department;
import com.example.japworkshop.service.DepartmentService;
import com.example.japworkshop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping("/findByName")
    public ResponseEntity<Department> findByName(@RequestParam String departmentName){
        Department departmentByName = departmentService.findDepartmentByName(departmentName);
        return ResponseEntity.ok(departmentByName);
    }

    @GetMapping("/findByCity")
    public ResponseEntity<List<Department>> findByCity(@RequestParam String departmentCity){
        List<Department> departmentsByCity = departmentService.findDepartmentsByCity(departmentCity);
        return ResponseEntity.ok(departmentsByCity);
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto = departmentService.addDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @PutMapping("/departmentUpdate")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department){
        Department updateDepartment= departmentService.updateDepartment(department, id);
        return  ResponseEntity.ok(updateDepartment);
    }

    @DeleteMapping("/deleteDepartment")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findAllByName")
    public ResponseEntity<List<DepartmentDto>> findByAllName(@RequestParam String departmentName){
        List<DepartmentDto> dtos = departmentService.findAllByName(departmentName);
        return ResponseEntity.ok(dtos);
    }


}
