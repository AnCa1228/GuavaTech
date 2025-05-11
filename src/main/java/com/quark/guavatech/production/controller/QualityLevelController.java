package com.quark.guavatech.production.controller;

import com.quark.guavatech.production.dto.QualityLevelRequest;
import com.quark.guavatech.production.dto.QualityLevelResponse;
import com.quark.guavatech.production.service.QualityLevelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quality-levels")
@RequiredArgsConstructor
public class QualityLevelController {

    private final QualityLevelService service;

    @PostMapping
    public ResponseEntity<QualityLevelResponse> create(@Valid @RequestBody QualityLevelRequest request) {
        return ResponseEntity.status(201).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<QualityLevelResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualityLevelResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QualityLevelResponse> update(@PathVariable Long id, @Valid @RequestBody QualityLevelRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}