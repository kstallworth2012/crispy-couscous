package com.example.workflow.workmanagementapp.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.workflow.workmanagementapp.domain.entities.AssignmentsEntity;

@Repository
public interface AssignmentsRepository extends CrudRepository<AssignmentsEntity, UUID>,
PagingAndSortingRepository<AssignmentsEntity, UUID>{

}
