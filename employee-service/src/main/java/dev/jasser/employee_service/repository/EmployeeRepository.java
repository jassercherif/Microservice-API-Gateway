package dev.jasser.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.jasser.employee_service.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Employee  findByUserId(Long userId);
}
