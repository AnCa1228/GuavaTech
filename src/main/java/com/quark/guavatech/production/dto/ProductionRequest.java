package com.quark.guavatech.production.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record ProductionRequest(@NotNull
                                Long lotId,

                                @NotNull
                                Long qualityId,

                                @NotNull
                                LocalDate harvestDate,

                                @NotNull
                                @PositiveOrZero
                                Double producedQuantity,
                                String qualityNotes
) {}
