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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	
	  	 @GetMapping(path = "/")
	     public List<AssignmentsDTO> listAssignments(){
	    	 List<AssignmentsEntity> assignments = assignmentService.findAll();
	    	 return assignments.stream().map(assignmentMapper::mapTo).collect(Collectors.toList());
	    			 }
	     
	     @GetMapping(path = "/{assignment_id}")
	     public ResponseEntity<AssignmentsDTO> getAssignments(@PathVariable("assignment_id") Long id){
	    	 Optional<AssignmentsEntity> foundAssignments = assignmentService.findOne(id);
	    	 return foundAssignments.map(assignmentEntity ->{
	    		 AssignmentsDTO assignmentDTO = assignmentMapper.mapTo(assignmentEntity);
	    		 return new ResponseEntity<>(assignmentDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	     
	     	//PAGEABLE
	@GetMapping(path="/")
	public Page<AssignmentsDTO> listAssignments(Pageable page){
		Page<AssignmentsEntity> assignments = assignmentService.findAll(page);
		return assignments.map(assignmentMapper::mapTo);
	}
	   
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     @PostMapping(path = "/new-assignment")
	     public ResponseEntity<AssignmentsDTO> createAssignment(@RequestBody AssignmentsDTO _assignmentsDTO){
	          
	     			AssignmentsEntity assignmentEntity = assignmentMapper.mapFrom(_assignmentsDTO);
	     	     	AssignmentsEntity savedAssignmentEntity = assignmentService.createAssignments(assignmentEntity);
	     	     	return new ResponseEntity<>(assignmentMapper.mapTo(savedAssignmentEntity), HttpStatus.CREATED);
	     }
	     
	     
	     
	     
	     
	     
	     
	     
	    
	 
	@DeleteMapping(path="/{id}")
	public ResponseEntity<AssignmentsDTO> deleteAssignment(@PathVariable("id") String id) {
		
		assignmentService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
       
	     
	     
	     
	     
	     
	     
	     
	 
}
