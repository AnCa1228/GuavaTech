package com.quark.guavatech.production.service;

import com.quark.guavatech.production.dto.ProductionRequest;
import com.quark.guavatech.production.dto.ProductionResponse;
import com.quark.guavatech.production.mapper.ProductionMapper;
import com.quark.guavatech.production.model.Production;
import com.quark.guavatech.production.repository.ProductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {

    private final ProductionRepository repository;
    private final ProductionMapper mapper;

    @Override
    public ProductionResponse create(ProductionRequest request) {
        Production production = mapper.toEntity(request);
        return mapper.toResponse(repository.save(production));
    }

    @Override
    public ProductionResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Producción no encontrada con ID: " + id));
    }

    @Override
    public List<ProductionResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Producción no encontrada con ID: " + id);
        }
        repository.deleteById(id);
    }
}
