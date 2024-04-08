package com.jpahibernate.jpahibernate.entities;

import com.jpahibernate.jpahibernate.dto.EmployeeAccountDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "employee_accounts")
@NoArgsConstructor
@Data
public class EmployeeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_no")
    private String accountNo;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
