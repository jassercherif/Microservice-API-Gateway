package dev.jasser.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jasser.employee_service.VO.ResponseTemplateVO;
import dev.jasser.employee_service.entity.Employee;
import dev.jasser.employee_service.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee){
        log.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getEmployeeWithDepartment(@PathVariable("id") Long employeeId){
        log.info("Inside getEmployeeWithDepartment of EmployeeController");
        return employeeService.getEmployeeWithDepartment(employeeId);
    }
    
    
    
}
