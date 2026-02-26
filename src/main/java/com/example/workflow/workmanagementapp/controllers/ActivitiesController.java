package com.example.workflow.workmanagementapp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
	     public ResponseEntity<ActivitiesDTO> getActivity(@PathVariable("activity_id") UUID id){
	    	 Optional<ActivitiesEntity> foundActivity = activitiesService.findOne(id);
	    	 return foundActivity.map(ActivitiesEntity ->{
	    		 ActivitiesDTO activitiesDTO = activitiesMapper.mapTo(ActivitiesEntity);
	    		 return new ResponseEntity<>(activitiesDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	     
	     
	     	//PAGEABLE
//	@GetMapping(path="/")
//	public Page<ActivitiesDTO> listActivities(Pageable page){
//		Page<ActivitiesEntity> activities = activitiesService.findAll(page);
//		return activities.map(activitiesMapper::mapTo);
//	}
	   
	     
	     
	     
	     
	     
	     
	     
	     @PostMapping(path = "/new-activity")
	     public ResponseEntity<ActivitiesDTO> createActivity(@RequestBody ActivitiesDTO _activitiesDTO){
	          
	     			ActivitiesEntity activityEntity = activitiesMapper.mapFrom(_activitiesDTO);
	     	     	ActivitiesEntity savedActivityEntity = activitiesService.createActivity(activityEntity);
	     	     	return new ResponseEntity<>(activitiesMapper.mapTo(savedActivityEntity), HttpStatus.CREATED);
	     }
	 
	
	     
	     
	     	
	@PutMapping(path="/{id}")
	public ResponseEntity<ActivitiesDTO> fullUpdateActivities(@PathVariable("id") UUID id, @RequestBody ActivitiesDTO activitiesDto){
		
		if(!activitiesService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		activitiesDto.setId(id);
		ActivitiesEntity activityEntity = activitiesMapper.mapFrom(activitiesDto);
		ActivitiesEntity savedActivitiesEntity = activitiesService.save(activityEntity);
		
		return new ResponseEntity<>(activitiesMapper.mapTo(savedActivitiesEntity), HttpStatus.OK); 
		
	}	
	
	
	
	@PatchMapping(path ="/{id}")
	public ResponseEntity<ActivitiesDTO> partialUpdate(@PathVariable("id") UUID id, @RequestBody ActivitiesDTO appDto){
		
		if(!activitiesService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		ActivitiesEntity activitiesEntity = activitiesMapper.mapFrom(appDto);
		ActivitiesEntity updatedActivity = activitiesService.partialUpdate(id, activitiesEntity);
		
		return new ResponseEntity<>(activitiesMapper.mapTo(updatedActivity), HttpStatus.OK);
		
		
		
	}
	
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	  
	 
	@DeleteMapping(path="/{id}")
	public ResponseEntity<ActivitiesDTO> deleteActivities(@PathVariable("id") UUID id) {
		
		activitiesService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
       
	
	
}
