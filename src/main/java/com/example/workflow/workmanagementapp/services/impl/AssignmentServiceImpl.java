package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.workflow.workmanagementapp.domain.entities.AssignmentsEntity;
import com.example.workflow.workmanagementapp.repositories.AssignmentsRepository;
import com.example.workflow.workmanagementapp.services.AssignmentsService;

@Service
public class AssignmentServiceImpl implements AssignmentsService {

	
	private AssignmentsRepository assignmentsRepository;
	
	
	
	public AssignmentServiceImpl(AssignmentsRepository assignmentsRepository) {
		this.assignmentsRepository = assignmentsRepository;
	}

	@Override
	public AssignmentsEntity createAssignments(AssignmentsEntity _assignments) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssignmentsEntity createAssignmentsUpdate(AssignmentsEntity _assignments) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssignmentsEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AssignmentsEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean isExists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
