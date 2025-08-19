package com.example.workflow.workmanagementapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;

public interface ProjectsRepository extends CrudRepository<ProjectsEntity, Long> {

}
