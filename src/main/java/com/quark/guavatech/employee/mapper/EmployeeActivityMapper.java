package com.quark.guavatech.employee.mapper;

import com.quark.guavatech.employee.dto.EmployeeActivityRequest;
import com.quark.guavatech.employee.dto.EmployeeActivityResponse;
import com.quark.guavatech.employee.model.EmployeeActivity;

public interface EmployeeActivityMapper {
    EmployeeActivity toEntity(EmployeeActivityRequest employeeActivityRequest);

    EmployeeActivityResponse toResponse(EmployeeActivity employeeActivity);
}
