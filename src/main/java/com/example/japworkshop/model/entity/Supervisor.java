package com.example.japworkshop.model.entity;

import com.example.japworkshop.model.EmployeeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToMany(mappedBy = "supervisor")
    private List<Employee>employees;
}
