package com.quark.guavatech.production.mapper;

import com.quark.guavatech.production.dto.ProductionRequest;
import com.quark.guavatech.production.dto.ProductionResponse;
import com.quark.guavatech.production.model.Production;

public interface ProductionMapper {
    Production toEntity(ProductionRequest request);
    ProductionResponse toResponse(Production production);
}
