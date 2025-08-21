package com.example.workflow.workmanagementapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workflow.workmanagementapp.domain.dto.AssignmentsDTO;
import com.example.workflow.workmanagementapp.domain.entities.AssignmentsEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;
import com.example.workflow.workmanagementapp.services.AssignmentsService;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentsController {
	
	private AssignmentsService assignmentService;
	private Mapper<AssignmentsEntity,AssignmentsDTO>   assignmentMapper;
	
	
	public AssignmentsController(AssignmentsService assignmentService,
			Mapper<AssignmentsEntity, AssignmentsDTO> assignmentMapper) {
		this.assignmentService = assignmentService;
		this.assignmentMapper = assignmentMapper;
	}

	
}
