package com.quark.guavatech.croplot.controller;

import com.quark.guavatech.croplot.dto.CropLotRequest;
import com.quark.guavatech.croplot.dto.CropLotResponse;
import com.quark.guavatech.croplot.service.CropLotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crop-lots")
@RequiredArgsConstructor
public class CropLotController {

    private final CropLotService cropLotService;

    @PostMapping
    public ResponseEntity<CropLotResponse> create(@Valid @RequestBody CropLotRequest request) {
        return ResponseEntity.status(201).body(cropLotService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CropLotResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cropLotService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CropLotResponse>> getAll() {
        return ResponseEntity.ok(cropLotService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CropLotResponse> update(@PathVariable Long id, @Valid @RequestBody CropLotRequest request) {
        return ResponseEntity.ok(cropLotService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cropLotService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
