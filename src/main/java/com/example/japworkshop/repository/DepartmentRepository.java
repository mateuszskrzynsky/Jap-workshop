package com.example.japworkshop.repository;

import com.example.japworkshop.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department>findByName(String name);

    List<Department>findAllByAddress_City(String city);


    List<Department> findByCity(String city);
}
