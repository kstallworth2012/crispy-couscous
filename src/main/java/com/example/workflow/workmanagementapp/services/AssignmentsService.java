package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.workflow.workmanagementapp.domain.entities.AssignmentsEntity;

public interface AssignmentsService {
	
	
	AssignmentsEntity createAssignments(AssignmentsEntity _assignments);
	AssignmentsEntity createAssignmentsUpdate(AssignmentsEntity _assignments);
	List<AssignmentsEntity> findAll();
    Page<AssignmentsEntity>findAll(Pageable pageable);
	Optional<AssignmentsEntity> findOne(Long id);
	 
	boolean isExists(Long id);
	
	AssignmentsEntity partialUpdate(UUID _id, AssignmentsEntity _assignments);
	
	void delete(UUID _id);
	 
}
