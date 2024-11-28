package net.javaguides.employee_app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "T_EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empId;
    private String name;
    private Integer age;
    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber;
    private String designation;
    private Double salary;
}
