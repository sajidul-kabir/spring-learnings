package com.jpahibernate.jpahibernate.services;

import com.jpahibernate.jpahibernate.dto.EmployeeAccountDto;
import com.jpahibernate.jpahibernate.dto.EmpolyeeAccountDetailsDto;
import com.jpahibernate.jpahibernate.entities.Employee;
import com.jpahibernate.jpahibernate.repositiories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public List<Employee> getEmployees() {
       return employeeRepository.findAll();
    }
    public Employee getEmployee(String name){
        return employeeRepository.findByName(name);
    }
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<EmployeeAccountDto> getAllAccountFromEmployee(Integer id){
        return employeeRepository.findEmployeeAccountsWithEmployeeId(id);
    }
    public List<EmpolyeeAccountDetailsDto>getAccountDetailsFromAEmployee(Integer id){
       return employeeRepository.findEmployeeAccountDetailsWithEmployeeId(id);
    }
}
