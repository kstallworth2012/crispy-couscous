package com.example.workflow.workmanagementapp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	     
	     
	     
	     	//PAGEABLE
	@GetMapping(path="/")
	public Page<ProjectsDTO> listProjects(Pageable page){
		Page<ProjectsEntity> projects = projectService.findAll(page);
		return projects.map(projectMapper::mapTo);
	}
	   
	     
	     
	     
	     
	     
	     
	     
	     @PostMapping(path = "/new-project")
	     public ResponseEntity<ProjectsDTO> createProject(@RequestBody ProjectsDTO _projectDTO){
	          
	     			ProjectsEntity projectEntity = projectMapper.mapFrom(_projectDTO);
	     	     	ProjectsEntity savedProjectEntity = projectService.createProject(projectEntity);
	     	     	return new ResponseEntity<>(projectMapper.mapTo(savedProjectEntity), HttpStatus.CREATED);
	     }
	
	     

	     
	     	
	@PutMapping(path="/{id}")
	public ResponseEntity<ProjectsDTO> fullUpdateProject(@PathVariable("id") String id, @RequestBody ProjectsDTO _projectDTO){
		
		if(!projectService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		_projectDTO.setId(id);
		ProjectsEntity projectEntity = projectMapper.mapFrom(_projectDTO);
		ProjectsEntity savedProjectEntity = projectService.save(projectEntity);
		
		return new ResponseEntity<>(projectMapper.mapTo(savedProjectEntity), HttpStatus.OK); 
		
	}	
	
	
	
	@PatchMapping(path ="{/id}")
	public ResponseEntity<ProjectsDTO> partialUpdate(@PathVariable("id") String id, @RequestBody ProjectsDTO _projectDTO){
		
		if(!projectService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		ProjectsEntity projectEntity = projectMapper.mapFrom(_projectDTO);
		ProjectsEntity updatedProject = projectService.partialUpdate(id, projectEntity);
		
		return new ResponseEntity<>(projectMapper.mapTo(updatedProject), HttpStatus.OK);
		
		
		
	}
	
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	
	     
	 
	@DeleteMapping(path="/{id}")
	public ResponseEntity<ProjectsDTO> deleteProject(@PathVariable("id") String id) {
		
		projectService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
       
	

}
