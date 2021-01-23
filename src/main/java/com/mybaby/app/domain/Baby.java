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
public class Baby extends BaseEntity {

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime birthday;

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private List<BabyParent> babyParents = new ArrayList<>();

    public void addBabyParent(Parent parent){
        BabyParent babyParent = new BabyParent();
        babyParent.setBaby(this);
        babyParent.setParent(parent);
        getBabyParents().add(babyParent);
    }

}


