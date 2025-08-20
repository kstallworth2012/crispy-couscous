package com.example.workflow.workmanagementapp.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.workflow.workmanagementapp.domain.dto.AssignmentsDTO;
import com.example.workflow.workmanagementapp.domain.dto.ProjectsDTO;
import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;

@Component
public class ProjectsMapperImpl implements Mapper<ProjectsEntity, ProjectsDTO> {

	
	private ModelMapper modelMapper;
	
	
	public ProjectsMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public ProjectsDTO mapTo(ProjectsEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a,ProjectsDTO.class);
	}

	@Override
	public ProjectsEntity mapFrom(ProjectsDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b,ProjectsEntity.class);
	}

}
