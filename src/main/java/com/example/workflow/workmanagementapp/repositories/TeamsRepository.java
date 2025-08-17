package com.example.workflow.workmanagementapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workflow.workmanagementapp.domain.entities.TeamsEntity;

@Repository
public interface TeamsRepository extends CrudRepository<TeamsEntity, Long> {

}
