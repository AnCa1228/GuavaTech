package com.quark.guavatech.production.mapper;

import com.quark.guavatech.production.dto.QualityLevelRequest;
import com.quark.guavatech.production.dto.QualityLevelResponse;
import com.quark.guavatech.production.model.QualityLevel;
import org.springframework.stereotype.Component;

@Component
public class QualityLevelMapperImpl implements QualityLevelMapper{

    @Override
    public QualityLevel toEntity(QualityLevelRequest request) {
        QualityLevel entity = new QualityLevel();
        entity.setName(request.name());
        entity.setDescription(request.description());
        return entity;
    }

    @Override
    public QualityLevelResponse toResponse(QualityLevel entity) {
        return new QualityLevelResponse(
                entity.getQualityId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}
