package com.example.japworkshop.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
//    @Column(name = "zarobki", nullable = false, length = 9)
    private BigDecimal salary;
    private LocalDate contractEnd;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    @JsonBackReference
    private Department department;

    @OneToOne
    private EntryCard entryCard;

    @ManyToOne
    @JoinColumn(name="supervisor_id")
    @JsonBackReference
    private Supervisor supervisor;

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setContractEnd(LocalDate contractEnd) {
        this.contractEnd = contractEnd;
    }

    public void setEntryCard(EntryCard entryCard) {
        this.entryCard = entryCard;
    }
}
