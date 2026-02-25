package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.workflow.workmanagementapp.domain.entities.TeamsEntity;
import com.example.workflow.workmanagementapp.repositories.TeamsRepository;
import com.example.workflow.workmanagementapp.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	


	private TeamsRepository teamsRepository;
	
	public TeamServiceImpl(TeamsRepository _teamsRepository) {
		this.teamsRepository = _teamsRepository;
	}
	
	@Override
	public TeamsEntity createTeam(TeamsEntity _team) {
		// TODO Auto-generated method stub
		return teamsRepository.save(_team);
	}

	@Override
	public TeamsEntity createTeamUpdate(TeamsEntity _team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamsEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(teamsRepository.findAll().spliterator(),false).collect(Collectors.toList());
	}

	@Override
	public Optional<TeamsEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return teamsRepository.findById(id);
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return teamsRepository.existsById(id);
	}

	@Override
	public Page<TeamsEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return teamsRepository.findAll(pageable);
	}

	@Override
	public TeamsEntity partialUpdate(UUID _id, TeamsEntity _team) {
		// TODO Auto-generated method stub
		_team.setId(_id);
	       return teamsRepository.findById(_id).map(existingTeam -> {
	            Optional.ofNullable(_team.getTitle()).ifPresent(existingTeam::setTitle);
	            return teamsRepository.save(existingTeam);
	        }).orElseThrow(() -> new RuntimeException("Team does not exist"));
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub
		teamsRepository.deleteById(_id);
	}

}
