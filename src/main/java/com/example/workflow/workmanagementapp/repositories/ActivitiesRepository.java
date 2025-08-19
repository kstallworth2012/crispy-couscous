package com.example.workflow.workmanagementapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;

public interface ActivitiesRepository extends CrudRepository<ActivitiesEntity, Long> {

}
