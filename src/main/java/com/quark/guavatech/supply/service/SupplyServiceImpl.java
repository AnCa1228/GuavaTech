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
public class SupplyServiceImpl implements SupplyService{

    private final SupplyRepository supplyRepository;
    private final SupplyMapper supplyMapper;

    //Metodo para crear un insumo
    @Override
    public SupplyResponse createSupply(SupplyRequest supplyRequest){
        if(supplyRepository.existsByName(supplyRequest.name())){
            throw new IllegalArgumentException("Ya existe un insumo con ese nombre");
        }

        if (supplyRequest.availableQuantity() < 0) {
            throw new IllegalArgumentException("La cantidad disponible no puede ser negativa");
        }
        if (supplyRequest.unitCost() < 0) {
            throw new IllegalArgumentException("El costo unitario no puede ser negativo");
        }
        Supply supply = supplyMapper.toEntity(supplyRequest);
        Supply savedSupply = supplyRepository.save(supply);
        return supplyMapper.toResponse(savedSupply);
    }

    //Metodo para obtener un insumo por Id
    @Override
    public SupplyResponse getSupplyById(Long id){
        if(id == null){
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        return supplyRepository.findById(id).
                map(supplyMapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Insumo no encontrado con ID: " + id));
    }

    //Metodo para mostrar todods los insumos
    @Override
    public List<SupplyResponse> getAllSupplies() {
        return supplyRepository.findAll().stream()
                .map(supplyMapper::toResponse)
                .collect(Collectors.toList());
    }

    //Metodo para actualizar insumos
    @Override
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
        String newName = supplyRequest.name();
        if (!existingSupply.getName().equals(newName)) {
            if (supplyRepository.existsByName(newName)) {
                throw new IllegalArgumentException("Ya existe un insumo con el nombre: " + newName);
            }
        }

        if (supplyRequest.availableQuantity() < 0) {
            throw new IllegalArgumentException("La cantidad disponible no puede ser negativa");
        }
        if (supplyRequest.unitCost() < 0) {
            throw new IllegalArgumentException("El costo unitario no puede ser negativo");
        }

        //Actualizacion de datos
        existingSupply.setName(supplyRequest.name());
        existingSupply.setUnit(supplyRequest.unit());
        existingSupply.setAvailableQuantity(supplyRequest.availableQuantity());
        existingSupply.setUnitCost(supplyRequest.unitCost());

        //Guardar cambios
        Supply updatedSupply = supplyRepository.save(existingSupply);

        return supplyMapper.toResponse(updatedSupply);
    }

    //Metodo para eliminar un insumo por ID
    @Override
    public void deleteSupply(Long id){
        if(!supplyRepository.existsById(id)){
            throw new NoSuchElementException("Insumo no encontrado con ID: " + id);
        }
        supplyRepository.deleteById(id);
    }
}
