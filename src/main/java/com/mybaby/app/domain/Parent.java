package com.mybaby.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "seq_parent", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent extends BaseEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String familyCode;

    @OneToMany(mappedBy = "parent")
    private List<BabyParent> babyParents;
}
