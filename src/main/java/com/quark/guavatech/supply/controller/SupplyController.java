package com.quark.guavatech.supply.controller;

import com.quark.guavatech.supply.dto.SupplyRequest;
import com.quark.guavatech.supply.dto.SupplyResponse;
import com.quark.guavatech.supply.service.SupplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplies")
@RequiredArgsConstructor
public class SupplyController {

    private final SupplyService supplyService;

    @PostMapping
    public ResponseEntity<SupplyResponse> create(@Valid @RequestBody SupplyRequest supplyRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplyService.createSupply(supplyRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplyResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(supplyService.getSupplyById(id));
    }

    @GetMapping
    public ResponseEntity<List<SupplyResponse>> getAll() {
        return ResponseEntity.ok(supplyService.getAllSupplies());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplyResponse> update(@PathVariable Long id, @Valid @RequestBody SupplyRequest request) {
        return ResponseEntity.ok(supplyService.updateSupply(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplyService.deleteSupply(id);
        return ResponseEntity.noContent().build();
    }
}
