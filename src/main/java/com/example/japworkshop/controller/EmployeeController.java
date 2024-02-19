package com.example.japworkshop.controller;

import com.example.japworkshop.model.dto.EmployeeDto;
import com.example.japworkshop.model.dto.NewEmployeeReq;
import com.example.japworkshop.model.entity.Employee;
import com.example.japworkshop.repository.EmployeeRepository;
import com.example.japworkshop.service.EmployeeService;
import com.example.japworkshop.service.InitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @PostMapping("/new")
    public ResponseEntity<Void> addEmployee(@RequestBody NewEmployeeReq newEmployee) {
        employeeService.addEmployee(newEmployee);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByLastName")
    public ResponseEntity<List<EmployeeDto>> findEmployeesByLastName(@RequestParam String lastName) {
        List<EmployeeDto> employees = employeeService.findEmployeesByLastName(lastName);
        return ResponseEntity.ok(employees);
    }

    @PatchMapping("/updateSalary")
    public ResponseEntity<Void> updateSalary(@RequestParam String lastName, @RequestParam BigDecimal newSalary) {
        employeeRepository.updateSalary(lastName, newSalary);
        return ResponseEntity.ok().build();
    }
}