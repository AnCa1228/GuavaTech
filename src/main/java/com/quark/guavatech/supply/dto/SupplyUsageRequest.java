package com.quark.guavatech.supply.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record SupplyUsageRequest(@NotNull
                                 Long activityId,

                                 @NotNull
                                 Long supplyId,

                                 @NotNull
                                 @PositiveOrZero(message = "La cantidad utilizada no puede ser negativa")
                                 Double usedQuantity) {
}
