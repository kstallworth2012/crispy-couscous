package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.repositories.ActivitiesRepository;
import com.example.workflow.workmanagementapp.services.ActivitiesService;


@Service
public class ActivitiesServiceImpl implements ActivitiesService {

	
	private ActivitiesRepository activitiesRepository;
	
	
	
	
	public ActivitiesServiceImpl(ActivitiesRepository activitiesRepository) {
		this.activitiesRepository = activitiesRepository;
	}

	@Override
	public ActivitiesEntity createActivity(ActivitiesEntity _activity) {
		// TODO Auto-generated method stub
		return activitiesRepository.save(_activity);
	}

	@Override
	public ActivitiesEntity createActivityUpdate(ActivitiesEntity _activity) {
		// TODO Auto-generated method stub
		return activitiesRepository.save(_activity);
	}

	@Override
	public List<ActivitiesEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(activitiesRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

	@Override
	public Optional<ActivitiesEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return activitiesRepository.findById(id);
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return activitiesRepository.existsById(id);
	}

	@Override
	public Page<ActivitiesEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return activitiesRepository.findAll(pageable);
	}

	@Override
	public ActivitiesEntity partialUpdate(UUID _id, ActivitiesEntity _activity) {
		// TODO Auto-generated method stub
		
		
		_activity.setActivity_id(_id);
		
	       return activitiesRepository.findById(_id).map(existingActivity -> {
	            Optional.ofNullable(_activity.getActivity_name()).ifPresent(existingActivity::setActivity_name);
	            return activitiesRepository.save(existingActivity);
	        }).orElseThrow(() -> new RuntimeException("Activity does not exist"));
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub
		activitiesRepository.deleteById(_id);
	}

	@Override
	public ActivitiesEntity save(ActivitiesEntity activityEntity) {
		// TODO Auto-generated method stub
		return activitiesRepository.save(activityEntity);
	}

}
