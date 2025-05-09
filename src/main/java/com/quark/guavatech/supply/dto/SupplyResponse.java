package com.quark.guavatech.supply.dto;

public record SupplyResponse(Long supplyId,
                             String name,
                             String unit,
                             double availableQuantity,
                             double unitCost) {
}
