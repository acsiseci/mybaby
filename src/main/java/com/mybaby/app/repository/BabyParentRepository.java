package com.mybaby.app.repository;

import com.mybaby.app.domain.BabyParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabyParentRepository extends JpaRepository<BabyParent, Long> {
}
