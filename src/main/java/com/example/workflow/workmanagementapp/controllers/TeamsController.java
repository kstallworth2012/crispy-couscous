package com.example.workflow.workmanagementapp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	     @GetMapping(path = "/")
	     public List<TeamsDTO> listTeams(){
	    	 List<TeamsEntity> teams = teamService.findAll();
	    	 return teams.stream().map(teamMapper::mapTo).collect(Collectors.toList());
	    			 }
	     
	     @GetMapping(path = "/{team_id}")
	     public ResponseEntity<TeamsDTO> getTeam(@PathVariable("team_id") UUID id){
	    	 Optional<TeamsEntity> foundTeam = teamService.findOne(id);
	    	 return foundTeam.map(teamEntity ->{
	    		 TeamsDTO teamDTO = teamMapper.mapTo(teamEntity);
	    		 return new ResponseEntity<>(teamDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	    
	 //PAGEABLE
	@GetMapping(path="/")
	public Page<TeamsDTO> listTeams(Pageable page){
		Page<TeamsEntity> teams = teamService.findAll(page);
		return teams.map(teamMapper::mapTo);
	}
	   
	     
	     
	     
	     
	     
	     
	     @PostMapping(path = "/new-team")
	     public ResponseEntity<TeamsDTO> createTeam(@RequestBody TeamsDTO _teamDTO){
	          
	     			TeamsEntity teamEntity = teamMapper.mapFrom(_teamDTO);
	     	     	TeamsEntity savedTeamEntity = teamService.createTeam(teamEntity);
	     	     	return new ResponseEntity<>(teamMapper.mapTo(savedTeamEntity), HttpStatus.CREATED);
	     }
	     
	     
	     
	 
	     
	     	
	@PutMapping(path="/{id}")
	public ResponseEntity<TeamsDTO> fullUpdateTeam(@PathVariable("id") UUID id, @RequestBody TeamsDTO _teamDTO){
		
		if(!teamService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		_teamDTO.setId(id);
		TeamsEntity teamEntity = teamMapper.mapFrom(_teamDTO);
		TeamsEntity savedTeamEntity = teamService.save(teamEntity);
		
		return new ResponseEntity<>(teamMapper.mapTo(savedTeamEntity), HttpStatus.OK); 
		
	}	
	
	
	
	@PatchMapping(path ="{/id}")
	public ResponseEntity<TeamsDTO> partialUpdate(@PathVariable("id") UUID id, @RequestBody TeamsDTO _teamDTO){
		
		if(!teamService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		TeamsEntity teamEntity = teamMapper.mapFrom(_teamDTO);
		TeamsEntity updatedTeam = teamService.partialUpdate(id, teamEntity);
		
		return new ResponseEntity<>(teamMapper.mapTo(updatedTeam), HttpStatus.OK);
		
		
		
	}
	

	     
	     
	     
	     
	       
	     
	 
	@DeleteMapping(path="/{id}")
	public ResponseEntity<TeamsDTO> deleteTeam(@PathVariable("id") UUID id) {
		
		teamService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
       
}
