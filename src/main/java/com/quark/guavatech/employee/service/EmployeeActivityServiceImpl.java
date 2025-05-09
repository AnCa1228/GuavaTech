package com.quark.guavatech.employee.service;

import com.quark.guavatech.employee.dto.EmployeeActivityRequest;
import com.quark.guavatech.employee.dto.EmployeeActivityResponse;
import com.quark.guavatech.employee.mapper.EmployeeActivityMapper;
import com.quark.guavatech.employee.model.EmployeeActivity;
import com.quark.guavatech.employee.repository.EmployeeActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeActivityServiceImpl implements EmployeeActivityService{

    private final EmployeeActivityRepository employeeActivityRepository;
    private final EmployeeActivityMapper employeeActivityMapper;

    //Metodo para añadir
    @Override
    public EmployeeActivityResponse create(EmployeeActivityRequest employeeActivityRequest) {
        EmployeeActivity entity = employeeActivityMapper.toEntity(employeeActivityRequest);
        EmployeeActivity saved = employeeActivityRepository.save(entity);
        return employeeActivityMapper.toResponse(saved);
    }

    //Metodo para listar lo que esta guardado
    @Override
    public List<EmployeeActivityResponse> getAll() {
        return employeeActivityRepository.findAll()
                .stream()
                .map(employeeActivityMapper::toResponse)
                .collect(Collectors.toList());
    }

    //Metodo para obtener por id
    @Override
    public EmployeeActivityResponse getById(Long id) {
        EmployeeActivity employeeActivity = employeeActivityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Actividad de empleado no encontrada con ID: " + id));
        return employeeActivityMapper.toResponse(employeeActivity);
    }

    //Metodo para eliminar por Id
    @Override
    public void deleteById(Long id) {
        if (!employeeActivityRepository.existsById(id)) {
            throw new NoSuchElementException("Actividad de empleado no encontrada con ID: " + id);
        }
        employeeActivityRepository.deleteById(id);
    }
}
