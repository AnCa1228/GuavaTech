package com.quark.guavatech.production.model;

import com.quark.guavatech.croplot.model.CropLot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "productions")
@Getter
@Setter
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_id")
    private Long productionId;

    @Column(name = "harvest_date", nullable = false)
    private LocalDate harvestDate;

    @Column(name = "produced_quantity", nullable = false)
    private double producedQuantity;

    @Column(name = "quality_notes", columnDefinition = "TEXT")
    private String qualityNotes;

    @ManyToOne
    @JoinColumn(name = "quality_id", nullable = false)
    private QualityLevel qualityLevel;

    @ManyToOne
    @JoinColumn(name = "lot_id", nullable = false)
    private CropLot cropLot;
}
