package com.quark.guavatech.production.service;

import com.quark.guavatech.production.dto.QualityLevelRequest;
import com.quark.guavatech.production.dto.QualityLevelResponse;
import com.quark.guavatech.production.mapper.QualityLevelMapper;
import com.quark.guavatech.production.model.QualityLevel;
import com.quark.guavatech.production.repository.QualityLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QualityLevelServiceImpl implements QualityLevelService{
    private final QualityLevelRepository repository;
    private final QualityLevelMapper mapper;

    @Override
    public QualityLevelResponse create(QualityLevelRequest request) {
        if (repository.existsByName(request.name())) {
            throw new IllegalArgumentException("Ya existe un nivel de calidad con ese nombre.");
        }
        QualityLevel entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public QualityLevelResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Nivel de calidad no encontrado con ID: " + id));
    }

    @Override
    public List<QualityLevelResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public QualityLevelResponse update(Long id, QualityLevelRequest request) {
        QualityLevel existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nivel de calidad no encontrado con ID: " + id));

        existing.setName(request.name());
        existing.setDescription(request.description());

        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Nivel de calidad no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }
}
