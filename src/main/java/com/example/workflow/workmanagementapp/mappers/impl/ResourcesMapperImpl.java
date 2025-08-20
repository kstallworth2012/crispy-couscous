package com.example.workflow.workmanagementapp.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.workflow.workmanagementapp.domain.dto.AssignmentsDTO;
import com.example.workflow.workmanagementapp.domain.dto.ResourcesDTO;
import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;

@Component
public class ResourcesMapperImpl implements Mapper<ResourcesEntity, ResourcesDTO> {

	
	
	private ModelMapper modelMapper;
	
	
	public ResourcesMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public ResourcesDTO mapTo(ResourcesEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a,ResourcesDTO.class);
	}

	@Override
	public ResourcesEntity mapFrom(ResourcesDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b,ResourcesEntity.class);
	}

}
