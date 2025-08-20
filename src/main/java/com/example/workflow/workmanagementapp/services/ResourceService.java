package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;

import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;

public interface ResourceService {
	
	
	ResourcesEntity createResource(ResourcesEntity _resource);
	ResourcesEntity createResourceUpdate(ResourcesEntity _resource);
	 List<ResourcesEntity> findAll();
	 
	 Optional<ResourcesEntity> findOne(Long id);
	 
	 boolean isExists(Long id);
}
