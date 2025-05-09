package com.quark.guavatech.supply.service;

import com.quark.guavatech.supply.model.SupplyDTO;

import java.util.List;

public interface SupplyService {
    SupplyDTO createSupply(SupplyDTO supplyDTO);
    SupplyDTO getSupplyById(Long id);
    List<SupplyDTO> getAllSupplies();
    SupplyDTO updateSupply(Long id,SupplyDTO supplyDTO);
    void deleteSupply(Long id);
}
