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

import com.example.workflow.workmanagementapp.domain.dto.ResourcesDTO;
import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;
import com.example.workflow.workmanagementapp.services.ResourceService;
import com.health.benefits.HealthBenefitsApplication.domain.dto.CarrierDTO;
import com.health.benefits.HealthBenefitsApplication.domain.entities.CarrierEntity;

@RestController
@RequestMapping("/api/resources")
public class ResourcesController {
	
	
	private ResourceService resourceService;
	private Mapper<ResourcesEntity,ResourcesDTO> resourceMapper;
	
	
	
	public ResourcesController(ResourceService resourceService, Mapper<ResourcesEntity, ResourcesDTO> resourceMapper) {
		this.resourceService = resourceService;
		this.resourceMapper = resourceMapper;
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
