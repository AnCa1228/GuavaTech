package com.quark.guavatech.employee.mapper;

import com.quark.guavatech.employee.dto.EmployeeRequest;
import com.quark.guavatech.employee.dto.EmployeeResponse;
import com.quark.guavatech.employee.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper{
    @Override
    public Employee toEntity(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();

        employee.setFirstName(employeeRequest.firstName());
        employee.setLastName(employeeRequest.lastName());

        return employee;
    }

    @Override
    public EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName()
        );
    }
}
