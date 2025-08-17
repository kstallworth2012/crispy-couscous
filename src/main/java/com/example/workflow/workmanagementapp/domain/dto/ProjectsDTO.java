package com.example.workflow.workmanagementapp.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectsDTO {
	private Long _id;
	
	private Long project_id;
	private String project_name;
	private String project_manager;
	private LocalDateTime start_date;
	private LocalDateTime end_date; 
	private String status;
}
