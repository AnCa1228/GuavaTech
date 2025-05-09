package com.quark.guavatech.activity.repository;

import com.quark.guavatech.activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
