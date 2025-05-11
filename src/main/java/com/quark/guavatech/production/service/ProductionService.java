package com.quark.guavatech.production.service;

import com.quark.guavatech.production.dto.ProductionRequest;
import com.quark.guavatech.production.dto.ProductionResponse;

import java.util.List;

public interface ProductionService {
    ProductionResponse create(ProductionRequest request);
    ProductionResponse getById(Long id);
    List<ProductionResponse> getAll();
    void delete(Long id);
}
