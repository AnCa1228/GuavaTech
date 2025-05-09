package com.quark.guavatech.employee.dto;

public record EmployeeActivityResponse(Long id,
                                       Long employeeId,
                                       String firstName,
                                       String lastName,
                                       Long activityId,
                                       String activityDescription,
                                       Double dailyCost) {
}
