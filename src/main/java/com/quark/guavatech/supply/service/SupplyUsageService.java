package com.quark.guavatech.supply.service;

import com.quark.guavatech.supply.dto.SupplyUsageRequest;
import com.quark.guavatech.supply.dto.SupplyUsageResponse;

import java.util.List;

public interface SupplyUsageService {
    SupplyUsageResponse create(SupplyUsageRequest supplyUsageRequest);
    List<SupplyUsageResponse> getAll();
    SupplyUsageResponse getById(Long id);
    void deleteById(Long id);
}
