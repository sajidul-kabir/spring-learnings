package sajid.cachetest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAccountDto implements Serializable {

    private Integer id;
    private String accountNo;
}
