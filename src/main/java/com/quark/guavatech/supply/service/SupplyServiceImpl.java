package com.quark.guavatech.supply.service;

import com.quark.guavatech.supply.dto.SupplyRequest;
import com.quark.guavatech.supply.dto.SupplyResponse;
import com.quark.guavatech.supply.mapper.SupplyMapper;
import com.quark.guavatech.supply.model.Supply;
import com.quark.guavatech.supply.repository.SupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl {
    private SupplyRepository supplyRepository;
    private SupplyMapper supplyMapper;

    //Metodo para crear un insumo
    public SupplyResponse createSupply(SupplyRequest supplyRequest){
        if(supplyRepository.existsByName(supplyRequest.getName())){
            throw new IllegalArgumentException("Ya existe un insumo con ese nombre");
        }

        if (supplyRequest.getAvailableQuantity() < 0) {
            throw new IllegalArgumentException("La cantidad disponible no puede ser negativa");
        }
        if (supplyRequest.getUnitCost() < 0) {
            throw new IllegalArgumentException("El costo unitario no puede ser negativo");
        }
        Supply supply = supplyMapper.toEntity(supplyRequest);
        Supply savedSupply = supplyRepository.save(supply);
        return supplyMapper.toResponse(savedSupply);
    }

    //Metodo para obtener un insumo por Id
    public SupplyResponse getSupplyById(Long id){
        if(id == null){
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        return supplyRepository.findById(id).
                map(supplyMapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Insumo no encontrado con ID: " + id));
    }

    //Metodo para mostrar todods los insumos
    public List<SupplyResponse> getAllSupplies(){
        return supplyRepository.findAll().stream()
                .map(supplyMapper::toResponse)
                .collect(Collectors.toList());
    }

    //Metodo para actualizar insumos
    public SupplyResponse updateSupply(Long id, SupplyRequest supplyRequest){
        if (id == null) {
            throw new IllegalArgumentException("El ID del insumo no puede ser nulo");
        }
        if (supplyRequest == null) {
            throw new IllegalArgumentException("Los datos de actualización no pueden ser nulos");
        }

        SupplyResponse existingSupplyResponse = getSupplyById(id);

        Supply existingSupply = supplyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Insumo no encontrado al recuperar entidad"));

        //Si el nombre cambio verificar que no sea igual a otro ya existente
        String newName = supplyRequest.getName();
        if (!existingSupply.getName().equals(newName)) {
            if (supplyRepository.existsByName(newName)) {
                throw new IllegalArgumentException("Ya existe un insumo con el nombre: " + newName);
            }
        }

        if (supplyRequest.getAvailableQuantity() < 0) {
            throw new IllegalArgumentException("La cantidad disponible no puede ser negativa");
        }
        if (supplyRequest.getUnitCost() < 0) {
            throw new IllegalArgumentException("El costo unitario no puede ser negativo");
        }

        //Actualizacion de datos
        existingSupply.setName(supplyRequest.getName());
        existingSupply.setUnit(supplyRequest.getUnit());
        existingSupply.setAvailableQuantity(supplyRequest.getAvailableQuantity());
        existingSupply.setUnitCost(supplyRequest.getUnitCost());

        //Guardar cambios
        Supply updatedSupply = supplyRepository.save(existingSupply);

        return supplyMapper.toResponse(updatedSupply);
    }

    public void deleteSupply(Long id){
        if(!supplyRepository.existsById(id)){
            throw new NoSuchElementException("Insumo no encontrado con ID: " + id);
        }
        supplyRepository.deleteById(id);
    }
}
