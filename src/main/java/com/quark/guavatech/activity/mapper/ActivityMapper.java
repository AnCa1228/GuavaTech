package com.quark.guavatech.activity.mapper;

import com.quark.guavatech.activity.dto.ActivityRequest;
import com.quark.guavatech.activity.dto.ActivityResponse;
import com.quark.guavatech.activity.model.Activity;

public interface ActivityMapper {
    Activity toEntity(ActivityRequest activityRequest);

    ActivityResponse toResponse(Activity activity);
}
