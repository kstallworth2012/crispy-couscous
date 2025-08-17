package com.example.workflow.workmanagementapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workflow.workmanagementapp.domain.entities.SchedulesEntity;


@Repository
public interface SchedulesRepository extends CrudRepository<SchedulesEntity, Long> {

}
