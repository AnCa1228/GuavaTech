package com.quark.guavatech.activity.service;

import com.quark.guavatech.activity.dto.ActivityTypeRequest;
import com.quark.guavatech.activity.dto.ActivityTypeResponse;
import com.quark.guavatech.activity.mapper.ActivityTypeMapper;
import com.quark.guavatech.activity.model.ActivityType;
import com.quark.guavatech.activity.repository.ActivityTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository repository;
    private final ActivityTypeMapper mapper;

    @Override
    public ActivityTypeResponse create(ActivityTypeRequest request) {
        if (repository.existsByName(request.name())) {
            throw new IllegalArgumentException("Ya existe un tipo de actividad con ese nombre.");
        }
        ActivityType entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public ActivityTypeResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Tipo de actividad no encontrado"));
    }

    @Override
    public List<ActivityTypeResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Tipo de actividad no encontrado");
        }
        repository.deleteById(id);
    }
}
