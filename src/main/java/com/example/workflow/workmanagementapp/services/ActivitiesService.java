package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;


public interface ActivitiesService {
	ActivitiesEntity createActivity(ActivitiesEntity _activity);
	ActivitiesEntity createActivityUpdate(ActivitiesEntity _activity);
	List<ActivitiesEntity> findAll();
	Page<ActivitiesEntity> findAll(Pageable pageable);
	Optional<ActivitiesEntity> findOne(UUID id);
	boolean isExists(UUID id);
	ActivitiesEntity partialUpdate(UUID _id, ActivitiesEntity _activity);
	void delete(UUID _id);
	ActivitiesEntity save(ActivitiesEntity activityEntity);
	
}
