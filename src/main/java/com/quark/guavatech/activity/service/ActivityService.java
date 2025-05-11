package com.quark.guavatech.activity.service;

import com.quark.guavatech.activity.dto.ActivityRequest;
import com.quark.guavatech.activity.dto.ActivityResponse;

import java.util.List;

public interface ActivityService {
    ActivityResponse create(ActivityRequest request);
    ActivityResponse getById(Long id);
    List<ActivityResponse> getAll();
    void deleteById(Long id);
}
