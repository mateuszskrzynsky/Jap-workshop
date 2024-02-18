package com.example.japworkshop.controller;

import com.example.japworkshop.model.entity.Department;
import com.example.japworkshop.service.DepartmentService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.addDepartment(department);
        return ResponseEntity.ok(savedDepartment);
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


}