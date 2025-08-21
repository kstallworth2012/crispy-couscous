package com.example.workflow.workmanagementapp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private Mapper<ProjectsEntity,ProjectsDTO> projectMapper;
	
	
	public ProjectsController(ProjectService projectService, Mapper<ProjectsEntity, ProjectsDTO> projectMapper) {
		this.projectService = projectService;
		this.projectMapper = projectMapper;
	}
	
	
	
 	 
	  	 @GetMapping(path = "/")
	     public List<ProjectsDTO> listProjects(){
	    	 List<ProjectsEntity> projects = projectService.findAll();
	    	 return projects.stream().map(projectMapper::mapTo).collect(Collectors.toList());
	    			 }
	     
	     @GetMapping(path = "/{project_id}")
	     public ResponseEntity<ProjectsDTO> getProject(@PathVariable("project_id") Long id){
	    	 Optional<ProjectsEntity> foundProject = projectService.findOne(id);
	    	 return foundProject.map(projectEntity ->{
	    		 ProjectsDTO projectDTO = projectMapper.mapTo(projectEntity);
	    		 return new ResponseEntity<>(projectDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	     @PostMapping(path = "/new-project")
	     public ResponseEntity<ProjectsDTO> createProject(@RequestBody ProjectsDTO _projectDTO){
	          
	     			ProjectsEntity projectEntity = projectMapper.mapFrom(_projectDTO);
	     	     	ProjectsEntity savedProjectEntity = projectService.createProject(projectEntity);
	     	     	return new ResponseEntity<>(projectMapper.mapTo(savedProjectEntity), HttpStatus.CREATED);
	     }
	
	
	
	

}
