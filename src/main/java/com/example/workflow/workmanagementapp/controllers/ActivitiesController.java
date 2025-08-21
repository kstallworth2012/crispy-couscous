package com.example.workflow.workmanagementapp.controllers;

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
	
	
	
	
	
}
