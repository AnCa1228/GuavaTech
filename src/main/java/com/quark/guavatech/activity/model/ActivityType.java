package com.quark.guavatech.activity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "acivity_types")
@Getter
@Setter
public class ActivityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeId;
    @Column(nullable = false, length = 50, unique = true)
    private String name;
}
