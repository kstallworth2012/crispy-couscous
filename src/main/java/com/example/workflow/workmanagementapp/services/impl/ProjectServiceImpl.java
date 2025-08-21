package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;
import com.example.workflow.workmanagementapp.repositories.ProjectsRepository;
import com.example.workflow.workmanagementapp.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	
	private ProjectsRepository projectsRepository;
	
	
	public ProjectServiceImpl(ProjectsRepository projectsRepository) {
		this.projectsRepository = projectsRepository;
	}

	@Override
	public ProjectsEntity createProject(ProjectsEntity _project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectsEntity createProjectUpdate(ProjectsEntity _project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectsEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ProjectsEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean isExists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
