package com.quark.guavatech.croplot.mapper;

import com.quark.guavatech.croplot.dto.CropLotRequest;
import com.quark.guavatech.croplot.dto.CropLotResponse;
import com.quark.guavatech.croplot.model.CropLot;

public interface CropLotMapper {
    CropLot toEntity(CropLotRequest request);
    CropLotResponse toResponse(CropLot cropLot);
}
