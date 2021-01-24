package com.mybaby.app.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "seq_parent", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Parent extends BaseEntity {

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String familyCode;

    @JoinTable(name = "baby_parent",
            joinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "baby_id", referencedColumnName = "id")
    )
    @OneToMany
    private List<Baby> babies = new ArrayList<>();

}
