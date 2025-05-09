package com.quark.guavatech.supply.controller;

import com.quark.guavatech.supply.dto.SupplyUsageRequest;
import com.quark.guavatech.supply.dto.SupplyUsageResponse;
import com.quark.guavatech.supply.service.SupplyUsageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supply-usages")
@RequiredArgsConstructor
public class SupplyUsageController {

    private final SupplyUsageService supplyUsageService;

    @PostMapping
    public ResponseEntity<SupplyUsageResponse> create(@Valid @RequestBody SupplyUsageRequest request) {
        SupplyUsageResponse response = supplyUsageService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<SupplyUsageResponse>> getAll() {
        return ResponseEntity.ok(supplyUsageService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplyUsageResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(supplyUsageService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplyUsageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
