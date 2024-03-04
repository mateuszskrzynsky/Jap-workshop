package com.example.japworkshop.service;

import com.example.japworkshop.model.Address;
import com.example.japworkshop.model.entity.Department;
import com.example.japworkshop.repository.DepartmentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class DepartmentServiceWithSpringBoot {

    @MockBean
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;

    static long start;
    static long finish;
    @BeforeAll
    static void beforeAll(){
        start = System.nanoTime();
    }

    @AfterAll
    static void afterAll(){
       finish = System.nanoTime();
       long timeElaspsed = finish - start;
       System.out.printf("Czas wykonania [%d] sekund",timeElaspsed / 1_000_000_000);
    }

    @Test
    void findByDepartmentName(){

        //given
        String departmentName = "IT";
        var department=new Department();
        department.setName(departmentName);
        department.setAddress(new Address("Anglia","Londyn","Buckingham Street","01011"));
        Mockito.when(departmentRepository.findByName(departmentName))
                .thenReturn(Optional.of(department));

        //when
        Department departmentByName = departmentService.findDepartmentByName(departmentName);


        //then
        Assertions.assertEquals(departmentName, departmentByName.getName());
    }

}
