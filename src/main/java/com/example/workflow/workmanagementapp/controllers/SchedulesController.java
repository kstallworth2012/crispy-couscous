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
	     public ResponseEntity<SchedulesDTO> getSchedule(@PathVariable("schedule_id") UUID id){
	    	 Optional<SchedulesEntity> foundSchedule = _scheduleService.findOne(id);
	    	 return foundSchedule.map(schedulesEntity ->{
	    		 SchedulesDTO scheduleDTO = scheduleMapper.mapTo(schedulesEntity);
	    		 return new ResponseEntity<>(scheduleDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	     
	     	//PAGEABLE
//	@GetMapping(path="/")
//	public Page<SchedulesDTO> listSchedules(Pageable page){
//		Page<SchedulesEntity> schedules = _scheduleService.findAll(page);
//		return schedules.map(scheduleMapper::mapTo);
//	}
	   
	     
	     
	     
	     
	     
	     @PostMapping(path = "/new-schedule")
	     public ResponseEntity<SchedulesDTO> createSchedule(@RequestBody SchedulesDTO _scheduleDTO){
	          
	     			SchedulesEntity scheduleEntity = scheduleMapper.mapFrom(_scheduleDTO);
	     	     	SchedulesEntity savedScheduleEntity = _scheduleService.createSchedule(scheduleEntity);
	     	     	return new ResponseEntity<>(scheduleMapper.mapTo(savedScheduleEntity), HttpStatus.CREATED);
	     }
	 
	     
	 
	     
	     	
	@PutMapping(path="/{id}")
	public ResponseEntity<SchedulesDTO> fullUpdateSchedule(@PathVariable("id") UUID id, @RequestBody SchedulesDTO _scheduleDTO){
		
		if(!_scheduleService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		_scheduleDTO.set_id(id);
		SchedulesEntity schedulesEntity = scheduleMapper.mapFrom(_scheduleDTO);
		SchedulesEntity savedScheduleEntity = _scheduleService.save(schedulesEntity);
		
		return new ResponseEntity<>(scheduleMapper.mapTo(savedScheduleEntity), HttpStatus.OK); 
		
	}	
	
	
	
	@PatchMapping(path ="/{id}")
	public ResponseEntity<SchedulesDTO> partialUpdate(@PathVariable("id") UUID id, @RequestBody SchedulesDTO _scheduleDTO){
		
		if(!_scheduleService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		SchedulesEntity schedulesEntity = scheduleMapper.mapFrom(_scheduleDTO);
		SchedulesEntity updatedSchedule = _scheduleService.partialUpdate(id, schedulesEntity);
		
		return new ResponseEntity<>(scheduleMapper.mapTo(updatedSchedule), HttpStatus.OK);
		
		
		
	}
	
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	      
	     
	 
	     	@DeleteMapping(path="/{id}")
	public ResponseEntity<SchedulesDTO> deleteSchedule(@PathVariable("id") UUID id) {
		
		_scheduleService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
       
	

}
