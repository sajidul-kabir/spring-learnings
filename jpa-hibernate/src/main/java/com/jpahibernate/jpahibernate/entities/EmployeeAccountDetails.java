package com.jpahibernate.jpahibernate.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_details")
@NoArgsConstructor
@Data
public class EmployeeAccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String details;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private EmployeeAccount employeeAccount;

}
