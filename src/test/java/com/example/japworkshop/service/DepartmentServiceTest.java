package com.example.japworkshop.service;

import com.example.japworkshop.model.Address;
import com.example.japworkshop.model.entity.Department;
import com.example.japworkshop.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    private DepartmentService departmentService;
    private DepartmentRepository departmentRepository;

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

    @BeforeEach
    void setUp(){
        departmentRepository = Mockito.mock(DepartmentRepository.class);
        departmentService = new DepartmentService(departmentRepository,new DepartmentMapper());
    }

    @Test
    void findDepartmentByName() {

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
        assertEquals(departmentName, departmentByName.getName());
        assertEquals("Anglia",departmentByName.getAddress().getCountry());
    }

    @Test
    void findDepartmentsByCity() {
        //given
        //when
        //then
    }

    @Test
    void addDepartment() {
        //given
        //when
        //then
    }

    @Test
    void deleteDepartment() {
        //given
        //when
        //then
    }

    @Test
    void findAllByName() {
        //given
        //when
        //then
    }
}