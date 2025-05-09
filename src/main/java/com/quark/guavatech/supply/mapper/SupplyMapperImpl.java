package com.quark.guavatech.supply.mapper;

import com.quark.guavatech.supply.dto.SupplyRequest;
import com.quark.guavatech.supply.dto.SupplyResponse;
import com.quark.guavatech.supply.model.Supply;
import org.springframework.stereotype.Component;

@Component
public class SupplyMapperImpl implements SupplyMapper{
    @Override
    public Supply toEntity(SupplyRequest supplyRequest) {
        Supply supply = new Supply();

        supply.setName(supplyRequest.name());
        supply.setUnit(supplyRequest.unit());
        supply.setAvailableQuantity(supplyRequest.availableQuantity());
        supply.setUnitCost(supplyRequest.unitCost());
        return supply;
    }

    @Override
    public SupplyResponse toResponse(Supply supply) {
        return new SupplyResponse(
                supply.getSupplyId(),
                supply.getName(),
                supply.getUnit(),
                supply.getAvailableQuantity(),
                supply.getUnitCost()
        );
    }
}
