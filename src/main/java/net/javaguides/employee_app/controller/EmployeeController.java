package net.javaguides.employee_app.controller;

import net.javaguides.employee_app.entity.Employee;
import net.javaguides.employee_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveEmployees")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employeeList){
        return employeeService.saveEmployeeData(employeeList);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployeeList(){
        return employeeService.getEmployeeList();
    }

    @GetMapping("/getEmployeeByEmpId/{empId}")
    public Employee getEmployee(@PathVariable Long empId){
        return employeeService.getEmployeeByEmpId(empId);
    }

}
