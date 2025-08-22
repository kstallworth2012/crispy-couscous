package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
		return projectsRepository.save(_project);
	}

	@Override
	public ProjectsEntity createProjectUpdate(ProjectsEntity _project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectsEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(projectsRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

	@Override
	public Optional<ProjectsEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return projectsRepository.findById(id);
	}

	@Override
	public boolean isExists(Long id) {
		// TODO Auto-generated method stub
		return projectsRepository.existsById(id);
	}

}
