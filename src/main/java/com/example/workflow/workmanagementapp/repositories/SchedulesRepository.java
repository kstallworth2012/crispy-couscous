package com.example.workflow.workmanagementapp.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.workflow.workmanagementapp.domain.entities.SchedulesEntity;


@Repository
public interface SchedulesRepository extends CrudRepository<SchedulesEntity, UUID>,
PagingAndSortingRepository<SchedulesEntity, UUID>{

}
