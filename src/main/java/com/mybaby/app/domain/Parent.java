package com.mybaby.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "seq_parent", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent extends BaseEntity {

    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;


    private String familyCode;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "parent")
    private List<BabyParent> babyParents;


    public Parent(@NotBlank @Size(max = 40) String familyCode,@NotBlank @Size(max = 40) String username,@NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.familyCode = familyCode;
        this.username = username;
    }
}
