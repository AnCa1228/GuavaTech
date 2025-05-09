package com.quark.guavatech.supply.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "supplies")
@Getter
@Setter
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supply_id")
    private Long supplyId;
    private String name;
    private String unit;
    @Column(name = "available_quantity")
    private double availableQuantity;
    @Column(name = "unit_cost")
    private double unitCost;
}
