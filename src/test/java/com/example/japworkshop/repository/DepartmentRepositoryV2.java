package com.example.japworkshop.repository;

import com.example.japworkshop.model.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@Sql(scripts = "data.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class DepartmentRepositoryV2 {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void test(){
        //when
        List<Department>departments = departmentRepository.findAllByName("IT");
        //then
        Assertions.assertEquals(1,departments.size());
    }
}
