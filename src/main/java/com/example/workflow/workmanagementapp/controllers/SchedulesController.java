package com.example.workflow.workmanagementapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workflow.workmanagementapp.domain.dto.SchedulesDTO;
import com.example.workflow.workmanagementapp.domain.entities.SchedulesEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;
import com.example.workflow.workmanagementapp.services.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class SchedulesController {
	
	
	private ScheduleService _scheduleService;
	private Mapper<SchedulesEntity,SchedulesDTO>   scheduleMapper;
	
	
	
	public SchedulesController(ScheduleService _scheduleService, Mapper<SchedulesEntity, SchedulesDTO> scheduleMapper) {
		this._scheduleService = _scheduleService;
		this.scheduleMapper = scheduleMapper;
	}
	
	
	
	

}
