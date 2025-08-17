package com.example.workflow.workmanagementapp.domain.dto;

import java.time.LocalDate;

import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivitiesDTO {
	private Long  activities_id;

	private ProjectsEntity project_id;
    private String activity_name; 
    private LocalDate start_date;
    private LocalDate end_date;
    private String status;
    private Integer total_float;
    private Double percent_complete;
}
