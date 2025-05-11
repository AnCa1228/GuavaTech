package com.quark.guavatech.activity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ActivityTypeRequest(@NotBlank(message = "El nombre del tipo de actividad no puede estar vacío")
                                  @Size(max = 50, message = "El nombre del tipo de actividad no puede exceder 50 caracteres")
                                  String name) {
}
