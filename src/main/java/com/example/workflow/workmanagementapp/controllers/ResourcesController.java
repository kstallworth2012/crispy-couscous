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

import com.example.workflow.workmanagementapp.domain.dto.ResourcesDTO;
import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;
import com.example.workflow.workmanagementapp.services.ResourceService;


@RestController
@RequestMapping("/api/resources")
public class ResourcesController {
	
	
	private ResourceService resourceService;
	private Mapper<ResourcesEntity,ResourcesDTO> resourceMapper;
	
	
	
	public ResourcesController(ResourceService resourceService, Mapper<ResourcesEntity, ResourcesDTO> resourceMapper) {
		this.resourceService = resourceService;
		this.resourceMapper = resourceMapper;
	}
	
	
	
	     @GetMapping(path = "/")
	     public List<ResourcesDTO> listResources(){
	    	 List<ResourcesEntity> resources = resourceService.findAll();
	    	 return resources.stream().map(resourceMapper::mapTo).collect(Collectors.toList());
	    			 }
	     
	     @GetMapping(path = "/{resource_id}")
	     public ResponseEntity<ResourcesDTO> getResource(@PathVariable("resource_id") Long id){
	    	 Optional<ResourcesEntity> foundResource = resourceService.findOne(id);
	    	 return foundResource.map(resourceEntity ->{
	    		 ResourcesDTO resourceDTO = resourceMapper.mapTo(resourceEntity);
	    		 return new ResponseEntity<>(resourceDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	     
	     
	     
	     	//PAGEABLE
	@GetMapping(path="/")
	public Page<ResourcesDTO> listResources(Pageable page){
		Page<ResourcesEntity> resources = resourceService.findAll(page);
		return resources.map(resourceMapper::mapTo);
	}
	   
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     @PostMapping(path = "/new-resource")
	     public ResponseEntity<ResourcesDTO> createResource(@RequestBody ResourcesDTO _resourceDTO){
	          
	     			ResourcesEntity resourceEntity = resourceMapper.mapFrom(_resourceDTO);
	     	     	ResourcesEntity savedResourceEntity = resourceService.createResource(resourceEntity);
	     	     	return new ResponseEntity<>(resourceMapper.mapTo(savedResourceEntity), HttpStatus.CREATED);
	     }
	 
	     
	     
	 
	@DeleteMapping(path="/{id}")
	public ResponseEntity<ResourcesDTO> deleteResource(@PathVariable("id") String id) {
		
		resourceService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
       
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
}
