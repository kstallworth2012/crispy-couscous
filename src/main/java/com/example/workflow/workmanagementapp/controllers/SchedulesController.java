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
import com.health.benefits.HealthBenefitsApplication.domain.dto.CarrierDTO;
import com.health.benefits.HealthBenefitsApplication.domain.entities.CarrierEntity;

@RestController
@RequestMapping("/api/schedules")
public class SchedulesController {
	
	
	private ScheduleService _scheduleService;
	private Mapper<SchedulesEntity,SchedulesDTO>   scheduleMapper;
	
	
	
	public SchedulesController(ScheduleService _scheduleService, Mapper<SchedulesEntity, SchedulesDTO> scheduleMapper) {
		this._scheduleService = _scheduleService;
		this.scheduleMapper = scheduleMapper;
	}
	
	
	/*
	     @GetMapping(path = "/")
	     public List<CarrierDTO> listCarriers(){
	    	 List<CarrierEntity> carriers = carrierService.findAll();
	    	 return carriers.stream().map(carrierMapper::mapTo).collect(Collectors.toList());
	    			 }
	     
	     @GetMapping(path = "/{carrier_id}")
	     public ResponseEntity<CarrierDTO> getCarrier(@PathVariable("carrier_id") Long id){
	    	 Optional<CarrierEntity> foundCarrier = carrierService.findOne(id);
	    	 return foundCarrier.map(carrierEntity ->{
	    		 CarrierDTO carrierDTO = carrierMapper.mapTo(carrierEntity);
	    		 return new ResponseEntity<>(carrierDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	     @PostMapping(path = "/new-carrier")
	     public ResponseEntity<CarrierDTO> createCarrier(@RequestBody CarrierDTO _carrierDTO){
	          
	     			CarrierEntity carrierEntity = carrierMapper.mapFrom(_carrierDTO);
	     	     	CarrierEntity savedCarrierEntity = carrierService.createCarrier(carrierEntity);
	     	     	return new ResponseEntity<>(carrierMapper.mapTo(savedCarrierEntity), HttpStatus.CREATED);
	     }
	 */
	

}
