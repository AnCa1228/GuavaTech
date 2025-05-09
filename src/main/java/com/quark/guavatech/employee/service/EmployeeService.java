package com.quark.guavatech.employee.service;

import com.quark.guavatech.employee.dto.EmployeeRequest;
import com.quark.guavatech.employee.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);
    EmployeeResponse getEmployeeById(Long id);
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest);
    void deleteEmployee(Long id);
}
