package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.workflow.workmanagementapp.domain.entities.SchedulesEntity;
import com.example.workflow.workmanagementapp.repositories.SchedulesRepository;
import com.example.workflow.workmanagementapp.services.ScheduleService;


@Service
public class ScheduleServiceImpl implements ScheduleService {

	
	private SchedulesRepository schedulesRepository;
	
	public ScheduleServiceImpl(SchedulesRepository _schedulesRepository) {
		this.schedulesRepository = _schedulesRepository;
	}

	@Override
	public SchedulesEntity createSchedule(SchedulesEntity _schedule) {
		// TODO Auto-generated method stub
		return schedulesRepository.save(_schedule);
	}

	@Override
	public SchedulesEntity createScheduleUpdate(SchedulesEntity _schedule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SchedulesEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(schedulesRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

	@Override
	public Optional<SchedulesEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return schedulesRepository.findById(id);
	}

	@Override
	public boolean isExists(Long id) {
		// TODO Auto-generated method stub
		return schedulesRepository.existsById(id);
	}

}
