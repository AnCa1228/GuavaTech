package com.quark.guavatech.supply.model;

import com.quark.guavatech.activity.model.Activity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "supply_usages")
@Getter
@Setter
public class SupplyUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usage_id")
    private Long usageId;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "supply_id", nullable = false)
    private Supply supply;

    @Column(name = "used_quantity")
    private double usedQuantity;
}
