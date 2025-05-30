package com.quark.guavatech.production.repository;

import com.quark.guavatech.production.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Long> {
}
