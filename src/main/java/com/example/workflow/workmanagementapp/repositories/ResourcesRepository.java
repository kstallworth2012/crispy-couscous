package com.example.workflow.workmanagementapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;

public interface ResourcesRepository extends CrudRepository<ResourcesEntity, Long> {

}
