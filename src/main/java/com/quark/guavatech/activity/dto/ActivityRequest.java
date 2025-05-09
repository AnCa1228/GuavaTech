package com.quark.guavatech.activity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ActivityRequest(@NotNull
                              Long activityId,

                              @NotBlank(message = "La fecha no puede estar vacía")
                              @Size(max = 20, message = "La fecha no puede exceder los 20 caracteres")
                              LocalDate date,

                              @NotBlank(message = "La descripcion no puede estar vacía")
                              @Size(max = 250, message = "La descripcion no puede exceder los 250 caracteres")
                              String description,

                              @NotNull
                              Long lotId,

                              @NotNull
                              Long userId) {
}
