package com.mybaby.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "seq_baby", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Baby extends BaseEntity {

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birthday;

    @JoinTable(name = "baby_parent",
            joinColumns = @JoinColumn(name = "baby_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "id")
    )
    @OneToMany
    private List<Parent> parents;
}
