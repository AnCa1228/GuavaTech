package com.quark.guavatech.employee.mapper;

import com.quark.guavatech.activity.model.Activity;
import com.quark.guavatech.activity.repository.ActivityRepository;
import com.quark.guavatech.employee.dto.EmployeeActivityRequest;
import com.quark.guavatech.employee.dto.EmployeeActivityResponse;
import com.quark.guavatech.employee.model.Employee;
import com.quark.guavatech.employee.model.EmployeeActivity;
import com.quark.guavatech.employee.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeActivityMapperImpl implements EmployeeActivityMapper{

    private final ActivityRepository activityRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeActivity toEntity(EmployeeActivityRequest employeeActivityRequest) {
        EmployeeActivity employeeActivity = new EmployeeActivity();

        Activity activity = activityRepository.findById(employeeActivityRequest.activityId())
                .orElseThrow(() -> new EntityNotFoundException("Actividad no encontrada con ID: " + employeeActivityRequest.activityId()));

        Employee employee = employeeRepository.findById(employeeActivityRequest.employeeId())
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado con ID: " + employeeActivityRequest.employeeId()));

        employeeActivity.setActivity(activity);
        employeeActivity.setEmployee(employee);
        employeeActivity.setDailyCost(employeeActivityRequest.dailyCost());

        return employeeActivity;
    }

    @Override
    public EmployeeActivityResponse toResponse(EmployeeActivity employeeActivity) {
        return new EmployeeActivityResponse(
                employeeActivity.getId(),
                employeeActivity.getEmployee().getEmployeeId(),
                employeeActivity.getEmployee().getFirstName(),
                employeeActivity.getEmployee().getLastName(),
                employeeActivity.getActivity().getActivityId(),
                employeeActivity.getActivity().getDescription(),
                employeeActivity.getDailyCost()
        );
    }
}
