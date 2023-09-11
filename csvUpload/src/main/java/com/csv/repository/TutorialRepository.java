package com.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csv.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
