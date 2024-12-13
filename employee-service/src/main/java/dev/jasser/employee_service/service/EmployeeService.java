package dev.jasser.employee_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.jasser.employee_service.VO.Department;
import dev.jasser.employee_service.VO.ResponseTemplateVO;
import dev.jasser.employee_service.entity.Employee;
import dev.jasser.employee_service.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RestTemplate restTemplate;
    public Employee saveEmployee(Employee employee){
        log.info("Inside saveEmployee of EmployeeService");
        return employeeRepository.save(employee);
    }

    public ResponseTemplateVO getEmployeeWithDepartment(Long employeeId){
        log.info("Inside getEmployeeWithDepartment of EmployeeService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Employee employee = employeeRepository.findByUserId(employeeId);
        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + employee.getDepartmentId() ,Department.class);
        vo.setEmployee(employee);
        vo.setDepartment(department);
        return vo;
    }
}
