package com.jpahibernate.jpahibernate.repositiories;

import com.jpahibernate.jpahibernate.dto.EmployeeAccountDto;
import com.jpahibernate.jpahibernate.dto.EmpolyeeAccountDetailsDto;
import com.jpahibernate.jpahibernate.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByName(String name);
    @Query("""
        SELECT new com.jpahibernate.jpahibernate.dto.EmployeeAccountDto(ea.id as id, ea.accountNo as accountNo)
        FROM 
        EmployeeAccount ea
        JOIN ea.employee e
        WHERE e.id = :employeeId
        """)
    List<EmployeeAccountDto> findEmployeeAccountsWithEmployeeId(Integer employeeId);

    @Query("""
        SELECT new com.jpahibernate.jpahibernate.dto.EmpolyeeAccountDetailsDto
        (e.name, new com.jpahibernate.jpahibernate.dto.EmployeeAccountDto
        (ea.id, ea.accountNo), ead.details)
        FROM
        EmployeeAccountDetails ead
        JOIN ead.employeeAccount ea
        JOIN ea.employee e
        WHERE e.id = :employeeId
        """
    )
    List<EmpolyeeAccountDetailsDto> findEmployeeAccountDetailsWithEmployeeId(Integer employeeId);

    //TODO: criteria api

}
