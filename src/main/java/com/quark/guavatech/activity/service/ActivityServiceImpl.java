package com.quark.guavatech.activity.service;

import com.quark.guavatech.activity.dto.ActivityRequest;
import com.quark.guavatech.activity.dto.ActivityResponse;
import com.quark.guavatech.activity.mapper.ActivityMapper;
import com.quark.guavatech.activity.model.Activity;
import com.quark.guavatech.activity.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository repository;
    private final ActivityMapper mapper;

    @Override
    public ActivityResponse create(ActivityRequest request) {
        Activity activity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(activity));
    }

    @Override
    public ActivityResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Actividad no encontrada"));
    }

    @Override
    public List<ActivityResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Actividad no encontrada");
        }
        repository.deleteById(id);
    }
}
