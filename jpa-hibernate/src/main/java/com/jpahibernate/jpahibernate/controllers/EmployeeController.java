package com.jpahibernate.jpahibernate.controllers;

import com.jpahibernate.jpahibernate.dto.EmployeeAccountDto;
import com.jpahibernate.jpahibernate.dto.EmpolyeeAccountDetailsDto;
import com.jpahibernate.jpahibernate.entities.Employee;
import com.jpahibernate.jpahibernate.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping("/")
    public List<Employee> getEmployees(){
        //System.out.println(employeeService.getEmployees());
       return employeeService.getEmployees();
    }
    @PostMapping("/")
    public Employee insertEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/employee")
    public Employee getEmployeeBtName(@RequestParam String name){
        return employeeService.getEmployee(name);
    }
    @GetMapping("/employee/accounts")
    public List<EmployeeAccountDto> getEmployeeAccounts(@RequestParam String id){
        return employeeService.getAllAccountFromEmployee(Integer.valueOf(id));
    }
    @GetMapping("/employee/accounts/details")
    public List<EmpolyeeAccountDetailsDto> getEmployeeAccountsDetails(@RequestParam String id){
        return employeeService.getAccountDetailsFromAEmployee(Integer.valueOf(id));
    }


}
