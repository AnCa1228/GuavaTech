package com.quark.guavatech.activity.service;

import com.quark.guavatech.activity.dto.ActivityTypeRequest;
import com.quark.guavatech.activity.dto.ActivityTypeResponse;

import java.util.List;

public interface ActivityTypeService {
    ActivityTypeResponse create(ActivityTypeRequest request);
    ActivityTypeResponse getById(Long id);
    List<ActivityTypeResponse> getAll();
    void deleteById(Long id);
}
