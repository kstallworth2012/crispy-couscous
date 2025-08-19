package com.example.workflow.workmanagementapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;

@Repository
public interface ResourcesRepository extends CrudRepository<ResourcesEntity, Long> {

}
