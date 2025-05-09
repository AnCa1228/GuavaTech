package com.quark.guavatech.supply.service;

import com.quark.guavatech.supply.dto.SupplyUsageRequest;
import com.quark.guavatech.supply.dto.SupplyUsageResponse;
import com.quark.guavatech.supply.mapper.SupplyUsageMapper;
import com.quark.guavatech.supply.model.SupplyUsage;
import com.quark.guavatech.supply.repository.SupplyUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplyUsageServiceImpl implements SupplyUsageService{

    private final SupplyUsageRepository supplyUsageRepository;
    private final SupplyUsageMapper supplyUsageMapper;

    //Metodo para añadir
    @Override
    public SupplyUsageResponse create(SupplyUsageRequest request) {
        SupplyUsage entity = supplyUsageMapper.toEntity(request);
        SupplyUsage saved = supplyUsageRepository.save(entity);
        return supplyUsageMapper.toResponse(saved);
    }

    //Metodo para mostrar lo guardado
    @Override
    public List<SupplyUsageResponse> getAll() {
        return supplyUsageRepository.findAll()
                .stream()
                .map(supplyUsageMapper::toResponse)
                .collect(Collectors.toList());
    }

    //Metodo para buscar por id
    @Override
    public SupplyUsageResponse getById(Long id) {
        SupplyUsage usage = supplyUsageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Uso de insumo no encontrado con ID: " + id));
        return supplyUsageMapper.toResponse(usage);
    }

    //Metodo para eliminar por id
    @Override
    public void deleteById(Long id) {
        if (!supplyUsageRepository.existsById(id)) {
            throw new NoSuchElementException("Uso de insumo no encontrado con ID: " + id);
        }
        supplyUsageRepository.deleteById(id);
    }
}
