package com.example.workflow.workmanagementapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workflow.workmanagementapp.domain.dto.ProjectsDTO;
import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;
import com.example.workflow.workmanagementapp.services.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectsController {
	
	
	private	ProjectService projectService;
	private Mapper<ProjectsEntity,ProjectsDTO>   projectMapper;
	
	
	public ProjectsController(ProjectService projectService, Mapper<ProjectsEntity, ProjectsDTO> projectMapper) {
		this.projectService = projectService;
		this.projectMapper = projectMapper;
	}
	
	

}
