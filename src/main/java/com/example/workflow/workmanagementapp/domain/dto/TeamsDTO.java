package com.example.workflow.workmanagementapp.domain.dto;

import java.util.UUID;

import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamsDTO {

	
	
	private UUID team_id;
    private String team_name;
    private String team_lead; 

    private ProjectsEntity project_id;

	public UUID getTeam_id() {
		return team_id;
	}

	public void setTeam_id(UUID team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_lead() {
		return team_lead;
	}

	public void setTeam_lead(String team_lead) {
		this.team_lead = team_lead;
	}

	public ProjectsEntity getProject_id() {
		return project_id;
	}

	public void setProject_id(ProjectsEntity project_id) {
		this.project_id = project_id;
	} 
    
    
    
    
}
