package com.example.workflow.workmanagementapp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workflow.workmanagementapp.domain.dto.ActivitiesDTO;
import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;
import com.example.workflow.workmanagementapp.services.ActivitiesService;

@RestController
@RequestMapping("/api/activities")
public class ActivitiesController {

	
	private ActivitiesService activitiesService;
	private Mapper<ActivitiesEntity,ActivitiesDTO> activitiesMapper;
	public ActivitiesController(ActivitiesService activitiesService,
			Mapper<ActivitiesEntity, ActivitiesDTO> activitiesMapper) {
		this.activitiesService = activitiesService;
		this.activitiesMapper = activitiesMapper;
	}
	
	
	 	 @GetMapping(path = "/")
	     public List<ActivitiesDTO> listActivities(){
	    	 List<ActivitiesEntity> activities = activitiesService.findAll();
	    	 return activities.stream().map(activitiesMapper::mapTo).collect(Collectors.toList());
	    			 }
	     
	     @GetMapping(path = "/{activity_id}")
	     public ResponseEntity<ActivitiesDTO> getActivity(@PathVariable("activity_id") Long id){
	    	 Optional<ActivitiesEntity> foundActivity = activitiesService.findOne(id);
	    	 return foundActivity.map(ActivitiesEntity ->{
	    		 ActivitiesDTO activitiesDTO = activitiesMapper.mapTo(ActivitiesEntity);
	    		 return new ResponseEntity<>(activitiesDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	     
	     
	     	//PAGEABLE
	@GetMapping(path="/")
	public Page<ActivitiesDTO> listActivities(Pageable page){
		Page<ActivitiesEntity> activities = activitiesService.findAll(page);
		return activities.map(activitiesMapper::mapTo);
	}
	   
	     
	     
	     
	     
	     
	     
	     
	     @PostMapping(path = "/new-activity")
	     public ResponseEntity<ActivitiesDTO> createActivity(@RequestBody ActivitiesDTO _activitiesDTO){
	          
	     			ActivitiesEntity activityEntity = activitiesMapper.mapFrom(_activitiesDTO);
	     	     	ActivitiesEntity savedActivityEntity = activitiesService.createActivity(activityEntity);
	     	     	return new ResponseEntity<>(activitiesMapper.mapTo(savedActivityEntity), HttpStatus.CREATED);
	     }
	 
	
	     
	     
	     /*
	 
	     	@DeleteMapping(path="/{id}")
	public ResponseEntity<ApplicantDto> deleteApplicant(@PathVariable("id") String id) {
		
		appService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
       */
	
	
}
