package com.quark.guavatech.supply.repository;

import com.quark.guavatech.supply.model.SupplyUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyUsageRepository extends JpaRepository<SupplyUsage, Long> {
}
