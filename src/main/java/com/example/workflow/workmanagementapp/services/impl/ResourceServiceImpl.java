package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;
import com.example.workflow.workmanagementapp.repositories.ResourcesRepository;
import com.example.workflow.workmanagementapp.services.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	private ResourcesRepository resourcesRepository;
	
	
	
	public ResourceServiceImpl(ResourcesRepository resourcesRepository) {
		this.resourcesRepository = resourcesRepository;
	}

	@Override
	public ResourcesEntity createResource(ResourcesEntity _resource) {
		// TODO Auto-generated method stub
		return resourcesRepository.save(_resource);
	}

	@Override
	public ResourcesEntity createResourceUpdate(ResourcesEntity _resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourcesEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(resourcesRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

	@Override
	public Optional<ResourcesEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return resourcesRepository.findById(id);
	}

	@Override
	public boolean isExists(Long id) {
		// TODO Auto-generated method stub
		return resourcesRepository.existsById(id);
	}

}
