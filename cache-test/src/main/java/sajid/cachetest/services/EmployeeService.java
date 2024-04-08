package sajid.cachetest.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Scheduled;
import sajid.cachetest.dto.EmployeeAccountDto;
import sajid.cachetest.dto.EmpolyeeAccountDetailsDto;
import sajid.cachetest.entities.Employee;
import sajid.cachetest.repositiories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Cacheable(value = "allEmployees")
    public List<Employee> getEmployees() {
       return employeeRepository.findAll();
    }
    @Cacheable(value = "employee", key = "{#name,#hello}")
    public Employee getEmployee(String name,String hello){

        Employee employee= employeeRepository.findByName(name);
        if(hello == null || hello.isEmpty()){
            System.out.println("NO HELLO");
        }
        else{
            employee.setName(employee.getName()+hello);
        }
        return employee;
    }

    @CacheEvict(value = "employees", allEntries = true)
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Cacheable(value = "employeeAccounts", key = "#id")
    public List<EmployeeAccountDto> getAllAccountFromEmployee(Integer id){
        return employeeRepository.findEmployeeAccountsWithEmployeeId(id);
    }
    @Cacheable(value = "employeeAccountDetails", key = "#id")
    public List<EmpolyeeAccountDetailsDto>getAccountDetailsFromAEmployee(Integer id){
       return employeeRepository.findEmployeeAccountDetailsWithEmployeeId(id);
    }

}
