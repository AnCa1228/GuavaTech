package com.quark.guavatech.croplot.mapper;

import com.quark.guavatech.croplot.dto.CropLotRequest;
import com.quark.guavatech.croplot.dto.CropLotResponse;
import com.quark.guavatech.croplot.model.CropLot;
import org.springframework.stereotype.Component;

@Component
public class CropLotMapperImpl implements CropLotMapper {

    @Override
    public CropLot toEntity(CropLotRequest request) {
        CropLot cropLot = new CropLot();
        cropLot.setName(request.name());
        cropLot.setLocation(request.location());
        cropLot.setStartDate(request.startDate());
        return cropLot;
    }

    @Override
    public CropLotResponse toResponse(CropLot entity) {
        return new CropLotResponse(
                entity.getLotId(),
                entity.getName(),
                entity.getLocation(),
                entity.getStartDate()
        );
    }
}
