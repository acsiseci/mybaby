package com.mybaby.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "baby_parents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BabyParent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "baby_id")
    @ManyToOne(fetch = FetchType.EAGER , optional = false)
    private Baby baby;
    @ManyToOne(fetch = FetchType.EAGER , optional = false)
    private Parent parent;

}