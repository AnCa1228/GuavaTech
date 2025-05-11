package com.quark.guavatech.activity.dto;

import java.time.LocalDate;

public record ActivityResponse(Long activityId,
                               String activityTypeName,
                               LocalDate date,
                               String description,
                               Long cropLotId,
                               String nameCropLot) {
}
