package com.example.japworkshop.repository;

import com.example.japworkshop.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    List<Employee> findByLastName(String lastName);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.salary = :upSalary WHERE e.lastName = :lastName")
    int updateSalary(@Param("lastName") String lastName, @Param("upSalary") BigDecimal upSalary);
}
