package com.example.japworkshop.service;

import com.example.japworkshop.model.Address;
import com.example.japworkshop.model.entity.Department;
import com.example.japworkshop.model.entity.Employee;
import com.example.japworkshop.model.entity.EntryCard;
import com.example.japworkshop.model.entity.Floor;
import com.example.japworkshop.repository.DepartmentRepository;
import com.example.japworkshop.repository.EmployeeRepository;
import com.example.japworkshop.repository.EntryCardRepository;
import com.example.japworkshop.repository.FloorRepository;
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

        Employee employee1 = new Employee();
        employee1.setFirstName("Mateusz");
        employee1.setLastName("Skrzyński");
        employee1.setSalary(new BigDecimal("9445"));
        employee1.setContractEnd(LocalDate.of(2025, Month.APRIL,22));
        employee1.setDepartment(department4);
        employee1.setEntryCard(entryCard1);

        employeeRepository.save(employee1);

    }


}
