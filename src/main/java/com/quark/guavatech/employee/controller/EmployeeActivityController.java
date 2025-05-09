package com.quark.guavatech.employee.controller;

import com.quark.guavatech.employee.dto.EmployeeActivityRequest;
import com.quark.guavatech.employee.dto.EmployeeActivityResponse;
import com.quark.guavatech.employee.service.EmployeeActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-activities")
@RequiredArgsConstructor
public class EmployeeActivityController {

    private final EmployeeActivityService employeeActivityService;

    @PostMapping
    public ResponseEntity<EmployeeActivityResponse> create(@Valid @RequestBody EmployeeActivityRequest request) {
        EmployeeActivityResponse response = employeeActivityService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeActivityResponse>> getAll() {
        return ResponseEntity.ok(employeeActivityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeActivityResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeActivityService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeActivityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
