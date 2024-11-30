package net.javaguides.employee_app.service;

import net.javaguides.employee_app.entity.Employee;
import net.javaguides.employee_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> saveEmployeeData(List<Employee> employeeList){
        return employeeRepository.saveAll(employeeList);
    }

    public List<Employee> updateEmployeeData(List<Employee> employeeList){
        return employeeRepository.saveAllAndFlush(employeeList);
    }


    public Employee getEmployeeByEmpId(Long empId) {
        return employeeRepository.findByEmpId(empId);
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public List<Employee> deleteEmployeeByDesignation(String designation) {
        return employeeRepository.deleteByDesignation(designation);
    }

    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }

    public List<Employee> getEmployeeByDesignation(String designation) {
        return employeeRepository.getByDesignation(designation);
    }

    public Page<Employee> getEmployeePagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        PageRequest pageable = null; 
        if(sortProperty != null) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sortProperty);
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "empId");
        }
        return employeeRepository.findAll(pageable);
    }
}
