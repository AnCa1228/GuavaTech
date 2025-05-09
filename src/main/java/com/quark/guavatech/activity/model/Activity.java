package com.quark.guavatech.activity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "activities")
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long activityId;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private ActivityType activityType;

    private LocalDate date;

    @Column(columnDefinition = "TEXT")
    private String description;

    /*
    @ManyToOne
    @JoinColumn(name =  "lot_id", nullable = false)
    private CropLot cropLot;

    @ManyToOne
    @JoinColumn(name =  "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.All)
    private List<SupplyUsage> supplyUsages
    */
}
