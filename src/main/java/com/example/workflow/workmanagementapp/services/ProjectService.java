package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;

public interface ProjectService {
	
	
	ProjectsEntity createProject(ProjectsEntity _project);
	ProjectsEntity createProjectUpdate(ProjectsEntity _project);
	 List<ProjectsEntity> findAll();
	 Page<ProjectsEntity> findAll(Pageable pageable);
	 Optional<ProjectsEntity> findOne(UUID id);
	 
	 boolean isExists(UUID id);
	 ProjectsEntity partialUpdate(UUID _id, ProjectsEntity _project);
	 void delete(UUID _id);
	 
}
