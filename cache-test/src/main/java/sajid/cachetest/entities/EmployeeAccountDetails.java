package sajid.cachetest.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "account_details")
@NoArgsConstructor
@Data
public class EmployeeAccountDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String details;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private EmployeeAccount employeeAccount;

}
