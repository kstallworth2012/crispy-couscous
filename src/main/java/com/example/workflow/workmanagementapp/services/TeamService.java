package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.workflow.workmanagementapp.domain.entities.TeamsEntity;


public interface TeamService {
	TeamsEntity createTeam(TeamsEntity _team);
    TeamsEntity createTeamUpdate(TeamsEntity _team);
	 List<TeamsEntity> findAll();
	 
	 Optional<TeamsEntity> findOne(Long id);
	 
	 boolean isExists(Long id);
}
