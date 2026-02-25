package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		return assignmentsRepository.save(_assignments);
	}

	@Override
	public AssignmentsEntity createAssignmentsUpdate(AssignmentsEntity _assignments) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssignmentsEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(assignmentsRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

	@Override
	public Optional<AssignmentsEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return assignmentsRepository.findById(id);
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return assignmentsRepository.existsById(id);
	}

	@Override
	public Page<AssignmentsEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return assignmentsRepository.findAll(pageable);
	}

	@Override
	public AssignmentsEntity partialUpdate(UUID _id, AssignmentsEntity _assignments) {
		// TODO Auto-generated method stub
		_assignments.setAssignment_id(_id);
	       return assignmentsRepository.findById(_id).map(existingAssignment -> {
	            Optional.ofNullable(_assignments.getActivity_id()).ifPresent(existingAssignment::setActivity_id);
	            return assignmentsRepository.save(existingAssignment);
	        }).orElseThrow(() -> new RuntimeException("Assignment does not exist"));
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub
		assignmentsRepository.deleteById(_id);
	}

	@Override
	public AssignmentsEntity save(AssignmentsEntity applicantEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
