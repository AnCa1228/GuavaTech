package com.quark.guavatech.activity.mapper;

import com.quark.guavatech.activity.dto.ActivityTypeRequest;
import com.quark.guavatech.activity.dto.ActivityTypeResponse;
import com.quark.guavatech.activity.model.ActivityType;

public interface ActivityTypeMapper {
    ActivityType toEntity(ActivityTypeRequest request);
    ActivityTypeResponse toResponse(ActivityType entity);
}

