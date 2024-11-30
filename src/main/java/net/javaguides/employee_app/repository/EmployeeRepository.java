package net.javaguides.employee_app.repository;

import net.javaguides.employee_app.entity.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmpId(Long empId);
    List<Employee> deleteByDesignation(String designation);
    List<Employee> getByDesignation(String designation);
}
