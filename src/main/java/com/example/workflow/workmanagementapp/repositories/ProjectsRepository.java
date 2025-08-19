package com.example.workflow.workmanagementapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;

@Repository
public interface ProjectsRepository extends CrudRepository<ProjectsEntity, Long> {

}
