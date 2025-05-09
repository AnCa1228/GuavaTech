package com.quark.guavatech.employee.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record EmployeeActivityRequest(@NotNull
                                      Long employeeId,

                                      @NotNull
                                      Long activityId,

                                      @NotNull
                                      @PositiveOrZero(message = "El costo diario no puede ser negativo")
                                      Double dailyCost) {
}
