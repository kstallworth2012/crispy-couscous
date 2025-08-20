package com.example.workflow.workmanagementapp.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.workflow.workmanagementapp.domain.dto.ActivitiesDTO;
import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;
import com.health.benefits.HealthBenefitsApplication.domain.dto.CarrierDTO;
import com.health.benefits.HealthBenefitsApplication.domain.entities.CarrierEntity;


@Component
public class ActivitiesMapperImpl implements Mapper<ActivitiesEntity, ActivitiesDTO> {

	private ModelMapper modelMapper;
	
	
	public ActivitiesMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public ActivitiesDTO mapTo(ActivitiesEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a,ActivitiesDTO.class);
	}

	@Override
	public ActivitiesEntity mapFrom(ActivitiesDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b,ActivitiesEntity.class);
	}

}
