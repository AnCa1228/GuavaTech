package com.quark.guavatech.activity.mapper;

import com.quark.guavatech.activity.dto.ActivityRequest;
import com.quark.guavatech.activity.dto.ActivityResponse;
import com.quark.guavatech.activity.model.Activity;
import com.quark.guavatech.activity.model.ActivityType;
import com.quark.guavatech.activity.repository.ActivityTypeRepository;
import com.quark.guavatech.croplot.model.CropLot;
import com.quark.guavatech.croplot.repository.CropLotRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityMapperImpl implements ActivityMapper{

    private final ActivityTypeRepository activityTypeRepository;
    private final CropLotRepository cropLotRepository;

    @Override
    public Activity toEntity(ActivityRequest request) {
        ActivityType type = activityTypeRepository.findById(request.activityTypeId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de actividad no encontrado"));
        CropLot lot = cropLotRepository.findById(request.cropLotId())
                .orElseThrow(() -> new EntityNotFoundException("Lote no encontrado"));

        Activity activity = new Activity();
        activity.setActivityType(type);
        activity.setCropLot(lot);
        activity.setDate(request.date());
        activity.setDescription(request.description());
        return activity;
    }

    @Override
    public ActivityResponse toResponse(Activity activity) {
        return new ActivityResponse(
                activity.getActivityId(),
                activity.getActivityType().getName(),
                activity.getDate(),
                activity.getDescription(),
                activity.getCropLot().getLotId(),
                activity.getCropLot().getName()
        );
    }
}
