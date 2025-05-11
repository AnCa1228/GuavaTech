package com.quark.guavatech.activity.repository;

import com.quark.guavatech.activity.model.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
    boolean existsByName(String name);
}
