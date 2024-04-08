package sajid.cachetest.controllers;

//import jakarta.persistence.Cache;
import jakarta.annotation.Nullable;
import org.aspectj.weaver.tools.cache.CacheStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import sajid.cachetest.dto.EmployeeAccountDto;
import sajid.cachetest.dto.EmpolyeeAccountDetailsDto;
import sajid.cachetest.entities.Employee;
import sajid.cachetest.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.actuate.cache.CachesEndpoint;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    //private final RedisTemplate<String, byte[]> redisTemplate;



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
    public Employee getEmployeeBtName(@RequestParam String name,@Nullable @RequestParam String hello){
        return employeeService.getEmployee(name,hello);
    }
    @GetMapping("/employee/accounts")
    public List<EmployeeAccountDto> getEmployeeAccounts(@RequestParam String id){
        return employeeService.getAllAccountFromEmployee(Integer.valueOf(id));
    }
    @GetMapping("/employee/accounts/details")
    public List<EmpolyeeAccountDetailsDto> getEmployeeAccountsDetails(@RequestParam String id){
        return employeeService.getAccountDetailsFromAEmployee(Integer.valueOf(id));
    }


//    @GetMapping("/employee-cache/{key}")
//    public Employee getEmployee(@PathVariable String key) {
//        byte[] bytes = redisTemplate.opsForValue().get(key);
//        if (bytes != null) {
//            return deserialize(bytes);
//        }
//        return null;
//    }
//
//    private Employee deserialize(byte[] bytes) {
//        try {
//            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//            ObjectInput in = new ObjectInputStream(bis);
//            return (Employee) in.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
