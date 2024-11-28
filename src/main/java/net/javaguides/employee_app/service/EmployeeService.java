package net.javaguides.employee_app.service;

import net.javaguides.employee_app.entity.Employee;
import net.javaguides.employee_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> saveEmployeeData(List<Employee> employeeList){
        return employeeRepository.saveAll(employeeList);
    }


    public Employee getEmployeeByEmpId(Long empId) {
        return employeeRepository.findByEmpId(empId);
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }
}
