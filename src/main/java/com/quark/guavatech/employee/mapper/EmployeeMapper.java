package com.quark.guavatech.employee.mapper;

import com.quark.guavatech.employee.dto.EmployeeRequest;
import com.quark.guavatech.employee.dto.EmployeeResponse;
import com.quark.guavatech.employee.model.Employee;

public interface EmployeeMapper {
    Employee toEntity(EmployeeRequest employeeRequest);

    EmployeeResponse toResponse(Employee employee);
}
