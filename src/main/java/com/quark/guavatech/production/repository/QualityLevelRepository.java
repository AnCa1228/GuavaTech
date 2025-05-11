package com.quark.guavatech.production.repository;

import com.quark.guavatech.production.model.QualityLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualityLevelRepository extends JpaRepository<QualityLevel, Long> {
    boolean existsByName(String name);
}