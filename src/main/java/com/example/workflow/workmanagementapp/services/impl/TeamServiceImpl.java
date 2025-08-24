package com.example.workflow.workmanagementapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
	public Optional<TeamsEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return teamsRepository.findById(id);
	}

	@Override
	public boolean isExists(Long id) {
		// TODO Auto-generated method stub
		return teamsRepository.existsById(id);
	}

}
