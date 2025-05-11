package com.quark.guavatech.production.mapper;

import com.quark.guavatech.croplot.model.CropLot;
import com.quark.guavatech.croplot.repository.CropLotRepository;
import com.quark.guavatech.production.dto.ProductionRequest;
import com.quark.guavatech.production.dto.ProductionResponse;
import com.quark.guavatech.production.model.Production;
import com.quark.guavatech.production.model.QualityLevel;
import com.quark.guavatech.production.repository.QualityLevelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductionMapperImpl implements ProductionMapper {

    private final CropLotRepository cropLotRepository;
    private final QualityLevelRepository qualityLevelRepository;

    @Override
    public Production toEntity(ProductionRequest request) {
        CropLot lot = cropLotRepository.findById(request.lotId())
                .orElseThrow(() -> new EntityNotFoundException("Lote no encontrado"));
        QualityLevel quality = qualityLevelRepository.findById(request.qualityId())
                .orElseThrow(() -> new EntityNotFoundException("Nivel de calidad no encontrado"));

        Production production = new Production();
        production.setCropLot(lot);
        production.setQualityLevel(quality);
        production.setHarvestDate(request.harvestDate());
        production.setProducedQuantity(request.producedQuantity());
        production.setQualityNotes(request.qualityNotes());

        return production;
    }

    @Override
    public ProductionResponse toResponse(Production entity) {
        return new ProductionResponse(
                entity.getProductionId(),
                entity.getHarvestDate(),
                entity.getProducedQuantity(),
                entity.getQualityNotes(),
                entity.getCropLot().getLotId(),
                entity.getCropLot().getName(),
                entity.getQualityLevel().getQualityId(),
                entity.getQualityLevel().getName()
        );
    }
}
