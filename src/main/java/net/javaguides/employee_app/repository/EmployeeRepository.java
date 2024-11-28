package net.javaguides.employee_app.repository;

import net.javaguides.employee_app.entity.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmpId(Long empId);
}
