package com.example.workflow.workmanagementapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workflow.workmanagementapp.domain.dto.TeamsDTO;
import com.example.workflow.workmanagementapp.domain.entities.TeamsEntity;
import com.example.workflow.workmanagementapp.mappers.Mapper;
import com.example.workflow.workmanagementapp.services.TeamService;

@RestController
@RequestMapping("/api/teams")
public class TeamsController {
	
	
	private TeamService teamService;
	private Mapper<TeamsEntity,TeamsDTO>   teamMapper;
	
	
	
	public TeamsController(TeamService teamService, Mapper<TeamsEntity, TeamsDTO> teamMapper) {
		this.teamService = teamService;
		this.teamMapper = teamMapper;
	}
	
	

}
