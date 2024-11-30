package net.javaguides.employee_app.controller;

import net.javaguides.employee_app.entity.Employee;
import net.javaguides.employee_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @DeleteMapping("/deleteEmployeeByDesignation/{designation}")
    public List<Employee> deleteEmployeeByDesignation(@PathVariable String designation){
        return employeeService.deleteEmployeeByDesignation(designation);
    }

    @DeleteMapping("/deleteAllEmployees")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployee();
    }

    @GetMapping("/getEmployeeByDesignation/{designation}")
    public List<Employee> getEmployeeByDesignation(@PathVariable String designation){
        return employeeService.getEmployeeByDesignation(designation);
    }

    @PutMapping("/updateEmployees")
    public List<Employee> updateEmployee(@RequestBody List<Employee> employeeList){
        return employeeService.saveEmployeeData(employeeList);
    }

    @RequestMapping(value = "/getEmployeePagination/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public Page<Employee> getEmployeePagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        return employeeService.getEmployeePagination(pageNumber, pageSize, null);
    }

    @RequestMapping(value = "/getEmployeePagination/{pageNumber}/{pageSize}/{sortProperty}", method = RequestMethod.GET)
    public Page<Employee> getEmployeePagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @PathVariable String sortProperty) {
        return employeeService.getEmployeePagination(pageNumber, pageSize, sortProperty);
    }


}
