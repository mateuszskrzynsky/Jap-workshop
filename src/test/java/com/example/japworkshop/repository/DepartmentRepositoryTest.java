package com.example.japworkshop.repository;

import com.example.japworkshop.model.Address;
import com.example.japworkshop.model.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    void test(){
        //given
        Department department1 = new Department();
        department1.setName("IT");
        department1.setAddress(new Address("Poland","Warsaw","Nowy Świat","00-100"));
        departmentRepository.save(department1);
        //when
        List<Department> departments =departmentRepository.findAllByName("IT");
        //then
        Assertions.assertEquals(1,departments.size());
    }
}