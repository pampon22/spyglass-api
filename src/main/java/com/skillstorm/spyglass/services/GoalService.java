package com.skillstorm.spyglass.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spyglass.models.Goal;
import com.skillstorm.spyglass.repositories.GoalRepository;

@Service
public class GoalService {
	
	@Autowired
	public GoalRepository repository;

	public Optional<Goal> findById(int id) {
		return repository.findById(id);
	}
	
	public List<Goal> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	public Goal save(@Valid Goal goal) {
		return repository.save(goal);
	}
	
//	@Transactional
//	public Goal update(@Valid Goal goal) {
//		return repository.save(goal);
//	}

	@Transactional
	public Optional<Goal> update(@Valid Goal goal) {
		return repository.findById(goal.getId()).map(newGoal -> {
			return repository.save(goal);
		});
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
