package com.quark.guavatech.supply.mapper;

import com.quark.guavatech.supply.dto.SupplyRequest;
import com.quark.guavatech.supply.dto.SupplyResponse;
import com.quark.guavatech.supply.model.Supply;

public interface SupplyMapper {
    Supply toEntity(SupplyRequest supplyRequest);

    SupplyResponse toResponse(Supply supply);
}
