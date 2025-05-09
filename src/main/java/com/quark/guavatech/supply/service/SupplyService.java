package com.quark.guavatech.supply.service;

import com.quark.guavatech.supply.dto.SupplyRequest;
import com.quark.guavatech.supply.dto.SupplyResponse;

import java.util.List;

public interface SupplyService {
    SupplyResponse createSupply(SupplyRequest supplyRequest);
    SupplyResponse getSupplyById(Long id);
    List<SupplyResponse> getAllSupplies();
    SupplyResponse updateSupply(Long id, SupplyRequest supplyRequest);
    void deleteSupply(Long id);
}
