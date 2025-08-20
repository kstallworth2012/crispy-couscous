package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;

import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;


public interface ActivitiesService {
	ActivitiesEntity createActivity(ActivitiesEntity _activity);
	ActivitiesEntity createActivityUpdate(ActivitiesEntity _activity);
	 List<ActivitiesEntity> findAll();
	 
	 Optional<ActivitiesEntity> findOne(Long id);
	 
	 boolean isExists(Long id);
}
