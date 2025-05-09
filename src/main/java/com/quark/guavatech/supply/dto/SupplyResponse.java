package com.quark.guavatech.supply.dto;

public record SupplyResponse(Long supplyId,
                             String name,
                             String unit,
                             Double availableQuantity,
                             Double unitCost) {
}
