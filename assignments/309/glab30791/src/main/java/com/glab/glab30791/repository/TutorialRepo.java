package com.glab.glab30791.repository;

import com.glab.glab30791.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TutorialRepo extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
}
