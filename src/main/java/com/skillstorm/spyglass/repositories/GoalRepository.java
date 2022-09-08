package com.skillstorm.spyglass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.spyglass.models.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {
	
}
