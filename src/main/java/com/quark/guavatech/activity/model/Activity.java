package com.quark.guavatech.activity.model;

import com.quark.guavatech.croplot.model.CropLot;
import com.quark.guavatech.employee.model.EmployeeActivity;
import com.quark.guavatech.supply.model.SupplyUsage;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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


    @ManyToOne
    @JoinColumn(name =  "lot_id", nullable = false)
    private CropLot cropLot;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<EmployeeActivity> employeeActivity;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<SupplyUsage> supplyUsages;

}
