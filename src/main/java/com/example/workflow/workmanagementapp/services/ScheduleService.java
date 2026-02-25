package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.workflow.workmanagementapp.domain.entities.SchedulesEntity;

public interface ScheduleService {
	
	
	SchedulesEntity createSchedule(SchedulesEntity _schedule);
	SchedulesEntity createScheduleUpdate(SchedulesEntity _schedule);
	List<SchedulesEntity> findAll();
	Page<SchedulesEntity> findAll(Pageable pageable); 
	Optional<SchedulesEntity> findOne(UUID id);
	 
	 boolean isExists(UUID id);
	 SchedulesEntity partialUpdate(UUID _id, SchedulesEntity _schedules);
	 void delete(UUID id);
	SchedulesEntity save(SchedulesEntity schedulesEntity);

}
