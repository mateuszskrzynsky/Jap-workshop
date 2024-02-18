package com.example.japworkshop.controller;

import com.example.japworkshop.model.dto.NewEmployeeReq;
import com.example.japworkshop.model.entity.Employee;
import com.example.japworkshop.service.EmployeeService;
import com.example.japworkshop.service.InitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/new")
    public ResponseEntity<Void> addEmployee(@RequestBody NewEmployeeReq newEmployee) {
        employeeService.addEmployee(newEmployee);
        return ResponseEntity.ok().build();
    }
}