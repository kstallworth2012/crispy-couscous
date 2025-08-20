package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;

import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;

public interface ProjectService {
	
	
	ProjectsEntity createProject(ProjectsEntity _project);
	ProjectsEntity createProjectUpdate(ProjectsEntity _project);
	 List<ProjectsEntity> findAll();
	 
	 Optional<ProjectsEntity> findOne(Long id);
	 
	 boolean isExists(Long id);
}
