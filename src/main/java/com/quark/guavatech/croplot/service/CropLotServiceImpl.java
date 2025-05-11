package com.quark.guavatech.croplot.service;

import com.quark.guavatech.croplot.dto.CropLotRequest;
import com.quark.guavatech.croplot.dto.CropLotResponse;
import com.quark.guavatech.croplot.mapper.CropLotMapper;
import com.quark.guavatech.croplot.model.CropLot;
import com.quark.guavatech.croplot.repository.CropLotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CropLotServiceImpl implements CropLotService {

    private final CropLotRepository repository;
    private final CropLotMapper mapper;

    @Override
    public CropLotResponse create(CropLotRequest request) {
        if (repository.existsByName(request.name())) {
            throw new IllegalArgumentException("Ya existe un lote con ese nombre.");
        }
        CropLot cropLot = mapper.toEntity(request);
        return mapper.toResponse(repository.save(cropLot));
    }

    @Override
    public CropLotResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Lote no encontrado con ID: " + id));
    }

    @Override
    public List<CropLotResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CropLotResponse update(Long id, CropLotRequest request) {
        CropLot existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Lote no encontrado con ID: " + id));

        existing.setName(request.name());
        existing.setLocation(request.location());
        existing.setStartDate(request.startDate());

        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Lote no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }
}
