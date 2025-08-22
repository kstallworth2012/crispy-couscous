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
	
	

	     @GetMapping(path = "/")
	     public List<SchedulesDTO> listSchedules(){
	    	 List<SchedulesEntity> schedules = _scheduleService.findAll();
	    	 return schedules.stream().map(scheduleMapper::mapTo).collect(Collectors.toList());
	    			 }
	     
	     @GetMapping(path = "/{schedule_id}")
	     public ResponseEntity<SchedulesDTO> getSchedule(@PathVariable("schedule_id") Long id){
	    	 Optional<SchedulesEntity> foundSchedule = _scheduleService.findOne(id);
	    	 return foundSchedule.map(schedulesEntity ->{
	    		 SchedulesDTO scheduleDTO = scheduleMapper.mapTo(schedulesEntity);
	    		 return new ResponseEntity<>(scheduleDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	     @PostMapping(path = "/new-schedule")
	     public ResponseEntity<SchedulesDTO> createSchedule(@RequestBody SchedulesDTO _scheduleDTO){
	          
	     			SchedulesEntity scheduleEntity = scheduleMapper.mapFrom(_scheduleDTO);
	     	     	SchedulesEntity savedScheduleEntity = _scheduleService.createSchedule(scheduleEntity);
	     	     	return new ResponseEntity<>(scheduleMapper.mapTo(savedScheduleEntity), HttpStatus.CREATED);
	     }
	 
	

}
