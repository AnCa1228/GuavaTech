package com.quark.guavatech.employee.service;

import com.quark.guavatech.employee.dto.EmployeeActivityRequest;
import com.quark.guavatech.employee.dto.EmployeeActivityResponse;

import java.util.List;

public interface EmployeeActivityService {
    EmployeeActivityResponse create(EmployeeActivityRequest employeeActivityRequest);
    List<EmployeeActivityResponse> getAll();
    EmployeeActivityResponse getById(Long id);
    void deleteById(Long id);
}
