package com.example.workflow.workmanagementapp.domain.dto;

import java.util.UUID;

import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;
import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssignmentsDTO {

	
	
	private UUID assignment_id;
    private ProjectsEntity project_id;
    private ActivitiesEntity activity_id;
    private ResourcesEntity resource_id;
    private String role;
	public UUID getAssignment_id() {
		return assignment_id;
	}
	public void setAssignment_id(UUID assignment_id) {
		this.assignment_id = assignment_id;
	}
    
    
}
