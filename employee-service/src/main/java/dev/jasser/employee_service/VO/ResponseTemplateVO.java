package dev.jasser.employee_service.VO;

import dev.jasser.employee_service.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Employee employee;
    private Department department;
}
