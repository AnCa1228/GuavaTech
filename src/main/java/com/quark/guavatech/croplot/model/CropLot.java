package com.quark.guavatech.croplot.model;

import com.quark.guavatech.activity.model.Activity;
import com.quark.guavatech.production.model.Production;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "crop_lots")
@Getter
@Setter
public class CropLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_id")
    private Long lotId;

    private String name;
    private String location;

    @Column(name = "start_date")
    private LocalDate startDate;

    @OneToMany(mappedBy = "cropLot", cascade = CascadeType.ALL)
    private List<Activity> activities;

    @OneToMany(mappedBy = "cropLot", cascade = CascadeType.ALL)
    private List<Production> productions;
}