package com.quark.guavatech.employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeRequest(@NotBlank(message = "El nombre no puede estar vacío")
                              @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
                              String firstName,

                              @NotBlank(message = "El apellido no puede estar vacío")
                              @Size(max = 20, message = "El apellido no puede exceder los 100 caracteres")
                              String lastName) {
}
