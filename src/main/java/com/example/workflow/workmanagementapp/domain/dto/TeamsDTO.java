package com.example.workflow.workmanagementapp.domain.dto;

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

	
	
	private Long team_id;
    private String team_name;
    private String team_lead; 

    private ProjectsEntity project_id; 
}
