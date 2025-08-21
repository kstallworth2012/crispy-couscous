package com.example.workflow.workmanagementapp.controllers;

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
	
	
	

}
