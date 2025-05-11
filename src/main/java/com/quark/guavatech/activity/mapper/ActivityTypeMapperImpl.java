package com.quark.guavatech.activity.mapper;

import com.quark.guavatech.activity.dto.ActivityTypeRequest;
import com.quark.guavatech.activity.dto.ActivityTypeResponse;
import com.quark.guavatech.activity.model.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class ActivityTypeMapperImpl implements ActivityTypeMapper {

    @Override
    public ActivityType toEntity(ActivityTypeRequest request) {
        ActivityType type = new ActivityType();
        type.setName(request.name());
        return type;
    }

    @Override
    public ActivityTypeResponse toResponse(ActivityType entity) {
        return new ActivityTypeResponse(entity.getTypeId(), entity.getName());
    }
}
