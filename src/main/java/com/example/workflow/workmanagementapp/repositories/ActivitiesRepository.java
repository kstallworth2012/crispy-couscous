package com.example.workflow.workmanagementapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;

@Repository
public interface ActivitiesRepository extends CrudRepository<ActivitiesEntity, Long> {

}
