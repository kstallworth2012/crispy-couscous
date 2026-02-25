package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Optional<ProjectsEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return projectsRepository.findById(id);
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return projectsRepository.existsById(id);
	}

	@Override
	public Page<ProjectsEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return projectsRepository.findAll(pageable);
	}

	@Override
	public ProjectsEntity partialUpdate(UUID _id, ProjectsEntity _project) {
		// TODO Auto-generated method stub
		   _project.setId(_id);
	       return projectsRepository.findById(_id).map(existingProject -> {
	            Optional.ofNullable(_project.getTitle()).ifPresent(existingProject::setTitle);
	            return projectsRepository.save(existingProject);
	        }).orElseThrow(() -> new RuntimeException("Project does not exist"));
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub
		projectsRepository.deleteById(_id);
	}

	@Override
	public ProjectsEntity save(ProjectsEntity projectEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
