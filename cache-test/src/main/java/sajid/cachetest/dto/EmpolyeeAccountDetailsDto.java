package sajid.cachetest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpolyeeAccountDetailsDto implements Serializable {
    private String employee_name;
    private EmployeeAccountDto account;
    private String account_details;
}
