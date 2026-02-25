package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public List<ResourcesEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(resourcesRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

	@Override
	public Optional<ResourcesEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return resourcesRepository.findById(id);
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return resourcesRepository.existsById(id);
	}

	@Override
	public Page<ResourcesEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return resourcesRepository.findAll(pageable);
	}

	@Override
	public ResourcesEntity partialEntity(UUID _id, ResourcesEntity _resource) {
		// TODO Auto-generated method stub
		_resource.setId(_id);
	       return resourcesRepository.findById(_id).map(existingResource -> {
	            Optional.ofNullable(_resource.getTitle()).ifPresent(existingResource::setTitle);
	            return resourcesRepository.save(existingResource);
	        }).orElseThrow(() -> new RuntimeException("Resource does not exist"));
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub
		resourcesRepository.deleteById(_id);
	}

	@Override
	public ResourcesEntity createResourceUpdate(ResourcesEntity _resource) {
		// TODO Auto-generated method stub
		return null;
	}

}
