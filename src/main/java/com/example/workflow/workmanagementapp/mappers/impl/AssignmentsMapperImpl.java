package com.example.workflow.workmanagementapp.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.workflow.workmanagementapp.domain.dto.ActivitiesDTO;
import com.example.workflow.workmanagementapp.domain.dto.AssignmentsDTO;
import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.domain.entities.AssignmentsEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;


@Component
public class AssignmentsMapperImpl implements Mapper<AssignmentsEntity, AssignmentsDTO> {

	
	private ModelMapper modelMapper;
	
	
	public AssignmentsMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public AssignmentsDTO mapTo(AssignmentsEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a,AssignmentsDTO.class);
	}

	@Override
	public AssignmentsEntity mapFrom(AssignmentsDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b,AssignmentsEntity.class);
	}

}
