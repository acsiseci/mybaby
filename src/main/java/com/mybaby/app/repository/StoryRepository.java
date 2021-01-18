package com.mybaby.app.repository;

import com.mybaby.app.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StoryRepository extends JpaRepository<Story,Long> {
    @Query(value = "SELECT s FROM Story s WHERE s.published = true ")
    public List<Story> mobileFindAll();


}