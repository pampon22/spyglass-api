package com.skillstorm.spyglass.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spyglass.models.Goal;
import com.skillstorm.spyglass.services.GoalService;

@CrossOrigin
@RestController
@RequestMapping("/goal")
public class GoalController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GoalController.class);
	
	@Autowired
	private GoalService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Goal> findById(@PathVariable int id) {
		return ResponseEntity.of(service.findById(id));
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public List<Goal> findAll() {
		return service.findAll();
	}
	
	
	@PostMapping
	public ResponseEntity<Goal> save(@Valid @RequestBody Goal goal) {
		return ResponseEntity.ok(service.save(goal));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Goal> update(@PathVariable int id, @RequestBody @Valid Goal goal) {
		Optional<Goal> g = service.findById(id);
		if (g.isEmpty()) {
			LOGGER.info("Goal not found");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.of(service.update(goal));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Goal> delete(@PathVariable Integer id) {
		Optional<Goal> g = service.findById(id);
		if (g.isPresent() ) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		LOGGER.info("Goal not found");
		return ResponseEntity.notFound().build();
		
	}
}
