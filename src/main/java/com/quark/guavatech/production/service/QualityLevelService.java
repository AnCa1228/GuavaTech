package com.quark.guavatech.production.service;

import com.quark.guavatech.production.dto.QualityLevelRequest;
import com.quark.guavatech.production.dto.QualityLevelResponse;

import java.util.List;

public interface QualityLevelService {
    QualityLevelResponse create(QualityLevelRequest request);
    QualityLevelResponse getById(Long id);
    List<QualityLevelResponse> getAll();
    QualityLevelResponse update(Long id, QualityLevelRequest request);
    void delete(Long id);
}
