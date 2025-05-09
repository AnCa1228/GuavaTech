package com.quark.guavatech.activity.dto;

import java.time.LocalDate;

public record ActivityResponse(Long activityId,
                               Long typeId,
                               String activityType,
                               LocalDate date,
                               String description,
                               Long lotId,
                               String cropLot,
                               Long userId,
                               String user) {
}
