package com.example.workflow.workmanagementapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.workflow.workmanagementapp.domain.entities.AssignmentsEntity;

public interface AssignmentsRepository extends CrudRepository<AssignmentsEntity, Long> {

}
