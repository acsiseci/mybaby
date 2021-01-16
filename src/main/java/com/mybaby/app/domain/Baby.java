package com.mybaby.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "baby")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Baby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String gender;
    private String name;
    private String birthday;
    @OneToMany(mappedBy = "baby",fetch = FetchType.LAZY)
    private List<Baby> babies = new ArrayList<>();

    public List<Parent> getParents(){
         List<Parent> parents = new ArrayList<>();
        for (Baby baby : getBabies()) {
            parents.addAll(baby.getParents());
        }

        return parents;




        //List<Baby> babies = getBabies();
        //List<Parent> parents = babies.get(0).getParents();
        //return  parents;
    }
}
