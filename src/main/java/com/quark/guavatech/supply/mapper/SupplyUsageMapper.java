package com.quark.guavatech.supply.mapper;

import com.quark.guavatech.supply.dto.SupplyUsageRequest;
import com.quark.guavatech.supply.dto.SupplyUsageResponse;
import com.quark.guavatech.supply.model.SupplyUsage;

public interface SupplyUsageMapper {
    SupplyUsage toEntity(SupplyUsageRequest supplyUsageRequest);

    SupplyUsageResponse toResponse(SupplyUsage supplyUsage);
}
