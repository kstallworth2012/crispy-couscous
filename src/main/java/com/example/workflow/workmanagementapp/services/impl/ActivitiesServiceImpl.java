package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.repositories.ActivitiesRepository;
import com.example.workflow.workmanagementapp.services.ActivitiesService;


@Service
public class ActivitiesServiceImpl implements ActivitiesService {

	
	private ActivitiesRepository activitiesRepository;
	
	
	
	
	public ActivitiesServiceImpl(ActivitiesRepository activitiesRepository) {
		this.activitiesRepository = activitiesRepository;
	}

	@Override
	public ActivitiesEntity createActivity(ActivitiesEntity _activity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivitiesEntity createActivityUpdate(ActivitiesEntity _activity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivitiesEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ActivitiesEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean isExists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
