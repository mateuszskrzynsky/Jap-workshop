package com.example.japworkshop.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class NewEmployeeReq {

    private String firstName;
    private String lastName;
    //    @Column(name = "zarobki", nullable = false, length = 9)
    private BigDecimal salary;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractEnd;
}
