package com.mybaby.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "seq_baby_parent", allocationSize = 1)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"baby_id", "parent_id"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BabyParent extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Baby baby;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Parent parent;
}
