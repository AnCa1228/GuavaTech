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
    private Long supplyId;
    private String name;
    private String unit;
    private double availableQuantity;
    private double unitCost;
}
