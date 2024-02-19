package com.example.japworkshop.service;

import com.example.japworkshop.model.Address;
import com.example.japworkshop.model.EmployeeType;
import com.example.japworkshop.model.entity.*;
import com.example.japworkshop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InitService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    private final EntryCardRepository entryCardRepository;

    private final FloorRepository floorRepository;
    private final SupervisorRepository supervisorRepository;

    public void createSimpleData(){

        Department department1 = new Department();
        department1.setName("IT");
        department1.setAddress(new Address("Poland", "Warsaw", "Nowy Świat", "00-001"));
        departmentRepository.save(department1);

        Department department2 = new Department();
        department2.setName("Sales");
        department2.setAddress(new Address("Poland", "Krakow", "Rynek Główny", "31-042"));
        departmentRepository.save(department2);

        Department department3 = new Department();
        department3.setName("Marketing");
        department3.setAddress(new Address("Poland", "Wroclaw", "Rynek", "50-001"));
        departmentRepository.save(department3);

        Department department4 = new Department();
        department4.setName("Finance");
        department4.setAddress(new Address("Poland", "Gdansk", "Targ Węglowy", "80-827"));
        departmentRepository.save(department4);

        Department department5 = new Department();
        department5.setName("HR");
        department5.setAddress(new Address("Poland", "Poznan", "Stary Rynek", "61-772"));
        departmentRepository.save(department5);

        Floor floor1=new Floor();
        floor1.setLevelNumber(1);
        floorRepository.save(floor1);

        Floor floor2=new Floor();
        floor2.setLevelNumber(2);
        floorRepository.save(floor2);

        Floor floor3=new Floor();
        floor3.setLevelNumber(3);
        floorRepository.save(floor3);

        EntryCard entryCard1= new EntryCard();
        entryCard1.setUuid(UUID.randomUUID());
        entryCard1.setFloorAccess(Set.of(floor1,floor3));
        entryCardRepository.save(entryCard1);

        EntryCard entryCard2= new EntryCard();
        entryCard2.setUuid(UUID.randomUUID());
        entryCard2.setFloorAccess(Set.of(floor3));
        entryCardRepository.save(entryCard2);

        EntryCard entryCard3= new EntryCard();
        entryCard3.setUuid(UUID.randomUUID());
        entryCard3.setFloorAccess(Set.of(floor2,floor3));
        entryCardRepository.save(entryCard3);

        EntryCard entryCard4= new EntryCard();
        entryCard4.setUuid(UUID.randomUUID());
        entryCard4.setFloorAccess(Set.of(floor2));
        entryCardRepository.save(entryCard4);

        EntryCard entryCard5= new EntryCard();
        entryCard5.setUuid(UUID.randomUUID());
        entryCard5.setFloorAccess(Set.of(floor1,floor2));
        entryCardRepository.save(entryCard5);

        EntryCard entryCard6= new EntryCard();
        entryCard6.setUuid(UUID.randomUUID());
        entryCard6.setFloorAccess(Set.of(floor1,floor2,floor3));
        entryCardRepository.save(entryCard6);

        EntryCard entryCard7= new EntryCard();
        entryCard7.setUuid(UUID.randomUUID());
        entryCard7.setFloorAccess(Set.of(floor2));
        entryCardRepository.save(entryCard7);

        EntryCard entryCard8= new EntryCard();
        entryCard8.setUuid(UUID.randomUUID());
        entryCard8.setFloorAccess(Set.of(floor1,floor2,floor3));
        entryCardRepository.save(entryCard8);

        Supervisor supervisor1= new Supervisor();
        supervisor1.setFirstName("Adam");
        supervisor1.setLastName("Wrona");
        supervisor1.setSalary(BigDecimal.valueOf(19000));
        supervisor1.setEmployeeType(EmployeeType.FULL_TIME);
        supervisorRepository.save(supervisor1);

        Supervisor supervisor2= new Supervisor();
        supervisor2.setFirstName("Marek");
        supervisor2.setLastName("Szpak");
        supervisor2.setSalary(BigDecimal.valueOf(11000));
        supervisor2.setEmployeeType(EmployeeType.CONTRACTOR);
        supervisorRepository.save(supervisor2);

        Supervisor supervisor3= new Supervisor();
        supervisor3.setFirstName("Tomasz");
        supervisor3.setLastName("Juzik");
        supervisor3.setSalary(BigDecimal.valueOf(15000));
        supervisor3.setEmployeeType(EmployeeType.FULL_TIME);
        supervisorRepository.save(supervisor3);

        Supervisor supervisor4= new Supervisor();
        supervisor4.setFirstName("Marta");
        supervisor4.setLastName("Szymanska");
        supervisor4.setSalary(BigDecimal.valueOf(17000));
        supervisor4.setEmployeeType(EmployeeType.FULL_TIME);
        supervisorRepository.save(supervisor4);

        Supervisor supervisor5= new Supervisor();
        supervisor5.setFirstName("Dawid");
        supervisor5.setLastName("Salomon");
        supervisor5.setSalary(BigDecimal.valueOf(12000));
        supervisor5.setEmployeeType(EmployeeType.CONTRACTOR);
        supervisorRepository.save(supervisor5);

        Employee employee1 = new Employee();
        employee1.setFirstName("Mateusz");
        employee1.setLastName("Skrzyński");
        employee1.setSalary(new BigDecimal("9445"));
        employee1.setContractEnd(LocalDate.of(2025, Month.APRIL,22));
        employee1.setDepartment(department4);
        employee1.setEntryCard(entryCard1);
        employee1.setSupervisor(supervisor5);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Mary");
        employee2.setLastName("Johnson");
        employee2.setSalary(new BigDecimal("7500"));
        employee2.setDepartment(department1);
        employee2.setSupervisor(supervisor1);
        employee2.setContractEnd(LocalDate.of(2024, 6, 30));
        employee2.setEntryCard(entryCard2);
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("John");
        employee3.setLastName("Doe");
        employee3.setSalary(new BigDecimal("6500.00"));
        employee3.setDepartment(department2);
        employee3.setSupervisor(supervisor2);
        employee3.setContractEnd(LocalDate.of(2025, 1, 15));
        employee3.setEntryCard(entryCard3);
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Jane");
        employee4.setLastName("Smith");
        employee4.setSalary(new BigDecimal("7500.25"));
        employee4.setDepartment(department3);
        employee4.setSupervisor(supervisor3);
        employee4.setContractEnd(LocalDate.of(2023, 12, 31));
        employee4.setEntryCard(entryCard4);
        employeeRepository.save(employee4);

        Employee employee5 = new Employee();
        employee5.setFirstName("Robert");
        employee5.setLastName("Brown");
        employee5.setSalary(new BigDecimal("4500.75"));
        employee5.setDepartment(department4);
        employee5.setSupervisor(supervisor4);
        employee5.setContractEnd(LocalDate.of(2022, 11, 1));
        employee5.setEntryCard(entryCard5);
        employeeRepository.save(employee5);

        Employee employee6 = new Employee();
        employee6.setFirstName("Samantha");
        employee6.setLastName("Lee");
        employee6.setSalary(new BigDecimal("8000.00"));
        employee6.setDepartment(department5);
        employee6.setSupervisor(supervisor5);
        employee6.setContractEnd(LocalDate.of(2026, 7, 31));
        employee6.setEntryCard(entryCard6);
        employeeRepository.save(employee6);

        Employee employee7 = new Employee();
        employee7.setFirstName("Michael");
        employee7.setLastName("Wang");
        employee7.setSalary(new BigDecimal("6200.50"));
        employee7.setDepartment(department1);
        employee7.setSupervisor(supervisor1);
        employee7.setContractEnd(LocalDate.of(2024, 9, 30));
        employee7.setEntryCard(entryCard7);
        employeeRepository.save(employee7);

        Employee employee8 = new Employee();
        employee8.setFirstName("Emily");
        employee8.setLastName("Jones");
        employee8.setSalary(new BigDecimal("7100.25"));
        employee8.setDepartment(department3);
        employee8.setSupervisor(supervisor3);
        employee8.setContractEnd(LocalDate.of(2023, 6, 30));
        employee8.setEntryCard(entryCard8);
        employeeRepository.save(employee8);



    }


}
