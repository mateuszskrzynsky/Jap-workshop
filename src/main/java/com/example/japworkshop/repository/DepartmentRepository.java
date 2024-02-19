package com.example.japworkshop.repository;

import com.example.japworkshop.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department>findByName(String name);

    List<Department>findAllByAddress_City(String city);
    @Query(value = "SELECT d from Department d where d.name= :name")
    List<Department> findAllByName(@Param("name")String name);


//    List<Department> findByCity(String city);
}
