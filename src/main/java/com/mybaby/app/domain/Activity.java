package com.mybaby.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "seq_baby", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String activity;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "baby_id",nullable = false)
    private Baby baby;

}