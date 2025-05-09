package com.quark.guavatech.supply.model;

public record SupplyDTO(Long supplyId,
                        String name,
                        String unit,
                        double availableQuantity,
                        double unit_cost) {
}
