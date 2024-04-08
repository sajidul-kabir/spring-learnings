package sajid.cachetest.repositiories;

import sajid.cachetest.dto.EmployeeAccountDto;
import sajid.cachetest.dto.EmpolyeeAccountDetailsDto;
import sajid.cachetest.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByName(String name);
    @Query("""
        SELECT new sajid.cachetest.dto.EmployeeAccountDto(ea.id as id, ea.accountNo as accountNo)
        FROM 
        EmployeeAccount ea
        JOIN ea.employee e
        WHERE e.id = :employeeId
        """)
    List<EmployeeAccountDto> findEmployeeAccountsWithEmployeeId(Integer employeeId);

    @Query("""
        SELECT new sajid.cachetest.dto.EmpolyeeAccountDetailsDto
        (e.name, new sajid.cachetest.dto.EmployeeAccountDto
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
