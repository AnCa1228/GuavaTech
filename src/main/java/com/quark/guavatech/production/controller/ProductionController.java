package com.quark.guavatech.production.controller;

import com.quark.guavatech.production.dto.ProductionRequest;
import com.quark.guavatech.production.dto.ProductionResponse;
import com.quark.guavatech.production.service.ProductionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productions")
@RequiredArgsConstructor
public class ProductionController {

    private final ProductionService productionService;

    @PostMapping
    public ResponseEntity<ProductionResponse> create(@Valid @RequestBody ProductionRequest request) {
        return ResponseEntity.status(201).body(productionService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductionResponse>> getAll() {
        return ResponseEntity.ok(productionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productionService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
