package com.jpahibernate.jpahibernate.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAccountDto {

    private Integer id;
    private String accountNo;
}
