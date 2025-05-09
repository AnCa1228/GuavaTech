package com.quark.guavatech.supply.dto;

public record SupplyUsageResponse(Long usageId,
                                  Long activityId,
                                  String activityDescription,
                                  Long supplyId,
                                  String supplyName,
                                  double usedQuantity) {
}
