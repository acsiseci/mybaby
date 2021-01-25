package com.mybaby.app.repository;

import com.mybaby.app.domain.Activity;
import com.mybaby.app.domain.Baby;
import com.mybaby.app.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findAllByBabyEquals(Baby baby);



}