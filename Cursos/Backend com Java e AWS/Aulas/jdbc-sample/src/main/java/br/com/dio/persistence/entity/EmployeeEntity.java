package br.com.dio.persistence.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class EmployeeEntity {

    private long id;
    private String firstName;
    private String lastName;
    private OffsetDateTime dateOfBirth;
    private BigDecimal salary;
}
