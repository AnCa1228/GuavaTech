package com.quark.guavatech.production.mapper;

import com.quark.guavatech.production.dto.QualityLevelRequest;
import com.quark.guavatech.production.dto.QualityLevelResponse;
import com.quark.guavatech.production.model.QualityLevel;

public interface QualityLevelMapper {
    QualityLevel toEntity(QualityLevelRequest request);
    QualityLevelResponse toResponse(QualityLevel qualityLevel);
}
