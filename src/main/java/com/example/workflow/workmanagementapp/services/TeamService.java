package com.example.workflow.workmanagementapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.workflow.workmanagementapp.domain.entities.TeamsEntity;


public interface TeamService {
	TeamsEntity createTeam(TeamsEntity _team);
    TeamsEntity createTeamUpdate(TeamsEntity _team);
	List<TeamsEntity> findAll();
	Page<TeamsEntity> findAll(Pageable pageable);
	Optional<TeamsEntity> findOne(UUID id);
	boolean isExists(UUID id);
	TeamsEntity partialUpdate(UUID _id, TeamsEntity _team);
	void delete(UUID _id);
}
