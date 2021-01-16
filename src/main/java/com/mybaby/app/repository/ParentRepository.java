package com.mybaby.app.repository;

import com.mybaby.app.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
        Parent findByUsername(String username);


}
