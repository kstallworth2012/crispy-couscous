package com.example.workflow.workmanagementapp.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.workflow.workmanagementapp.domain.entities.TeamsEntity;

@Repository
public interface TeamsRepository extends CrudRepository<TeamsEntity, UUID>,
					PagingAndSortingRepository<TeamsEntity, UUID>{

}
