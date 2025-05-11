package com.quark.guavatech.activity.controller;

import com.quark.guavatech.activity.dto.ActivityTypeRequest;
import com.quark.guavatech.activity.dto.ActivityTypeResponse;
import com.quark.guavatech.activity.service.ActivityTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-types")
@RequiredArgsConstructor
public class ActivityTypeController {

    private final ActivityTypeService service;

    @PostMapping
    public ResponseEntity<ActivityTypeResponse> create(@Valid @RequestBody ActivityTypeRequest request) {
        return ResponseEntity.status(201).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityTypeResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
