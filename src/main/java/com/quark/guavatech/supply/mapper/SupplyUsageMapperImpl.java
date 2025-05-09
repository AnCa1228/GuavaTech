package com.quark.guavatech.supply.mapper;

import com.quark.guavatech.activity.model.Activity;
import com.quark.guavatech.activity.repository.ActivityRepository;
import com.quark.guavatech.supply.dto.SupplyUsageRequest;
import com.quark.guavatech.supply.dto.SupplyUsageResponse;
import com.quark.guavatech.supply.model.Supply;
import com.quark.guavatech.supply.model.SupplyUsage;
import com.quark.guavatech.supply.repository.SupplyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplyUsageMapperImpl implements SupplyUsageMapper{

    private final ActivityRepository activityRepository;
    private final SupplyRepository supplyRepository;

    @Override
    public SupplyUsage toEntity(SupplyUsageRequest supplyUsageRequest) {
        SupplyUsage supplyUsage = new SupplyUsage();

        Activity activity = activityRepository.findById(supplyUsageRequest.activityId())
                .orElseThrow(() -> new EntityNotFoundException("Actividad no encontrada con ID: " + supplyUsageRequest.activityId()));

        Supply supply = supplyRepository.findById(supplyUsageRequest.supplyId())
                .orElseThrow(() -> new EntityNotFoundException("Insumo no encontrado con ID: " + supplyUsageRequest.supplyId()));

        supplyUsage.setActivity(activity);
        supplyUsage.setSupply(supply);
        supplyUsage.setUsedQuantity(supplyUsageRequest.usedQuantity());

        return supplyUsage;
    }

    @Override
    public SupplyUsageResponse toResponse(SupplyUsage supplyUsage) {
        return new SupplyUsageResponse(
                supplyUsage.getUsageId(),
                supplyUsage.getActivity().getActivityId(),
                supplyUsage.getActivity().getDescription(),
                supplyUsage.getSupply().getSupplyId(),
                supplyUsage.getSupply().getName(),
                supplyUsage.getUsedQuantity()
        );
    }
}
