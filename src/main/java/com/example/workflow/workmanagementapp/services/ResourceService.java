package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;

public interface ResourceService {
	
	
	ResourcesEntity createResource(ResourcesEntity _resource);
	ResourcesEntity createResourceUpdate(ResourcesEntity _resource);
	List<ResourcesEntity> findAll();
	Page<ResourcesEntity>  findAll(Pageable pageable);
	Optional<ResourcesEntity> findOne(UUID id);
	 
	boolean isExists(UUID id);
	ResourcesEntity partialEntity(UUID _id, ResourcesEntity _resource);
	void delete(UUID _id);
	ResourcesEntity partialUpdate(UUID id, ResourcesEntity resourceEntity);
	ResourcesEntity save(ResourcesEntity resourceEntity);
}
