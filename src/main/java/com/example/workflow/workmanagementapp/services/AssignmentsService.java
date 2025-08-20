package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;

import com.example.workflow.workmanagementapp.domain.entities.AssignmentsEntity;

public interface AssignmentsService {
	
	
	AssignmentsEntity createAssignments(AssignmentsEntity _assignments);
	AssignmentsEntity createAssignmentsUpdate(AssignmentsEntity _assignments);
	 List<AssignmentsEntity> findAll();
	 
	 Optional<AssignmentsEntity> findOne(Long id);
	 
	 boolean isExists(Long id);
}
