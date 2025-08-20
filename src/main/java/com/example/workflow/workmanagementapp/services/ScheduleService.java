package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;

import com.example.workflow.workmanagementapp.domain.entities.SchedulesEntity;

public interface ScheduleService {
	
	
	SchedulesEntity createSchedule(SchedulesEntity _schedule);
	SchedulesEntity createScheduleUpdate(SchedulesEntity _schedule);
	 List<SchedulesEntity> findAll();
	 
	 Optional<SchedulesEntity> findOne(Long id);
	 
	 boolean isExists(Long id);

}
