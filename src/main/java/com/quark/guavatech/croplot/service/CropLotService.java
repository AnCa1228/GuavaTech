package com.quark.guavatech.croplot.service;

import com.quark.guavatech.croplot.dto.CropLotRequest;
import com.quark.guavatech.croplot.dto.CropLotResponse;

import java.util.List;

public interface CropLotService {
    CropLotResponse create(CropLotRequest request);
    CropLotResponse getById(Long id);
    List<CropLotResponse> getAll();
    CropLotResponse update(Long id, CropLotRequest request);
    void delete(Long id);
}
