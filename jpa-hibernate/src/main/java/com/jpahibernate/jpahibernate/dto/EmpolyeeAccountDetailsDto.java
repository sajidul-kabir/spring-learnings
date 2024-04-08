package com.jpahibernate.jpahibernate.dto;

import com.jpahibernate.jpahibernate.entities.EmployeeAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpolyeeAccountDetailsDto {
    private String employee_name;
    private EmployeeAccountDto account;
    private String account_details;
}
