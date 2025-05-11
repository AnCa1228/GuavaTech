package com.quark.guavatech.croplot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CropLotRequest(@NotBlank
                             String name,

                             @NotBlank
                             String location,

                             @NotNull
                             LocalDate startDate
) {}
