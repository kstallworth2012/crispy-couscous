package com.example.workflow.workmanagementapp.domain.dto;

import java.time.LocalDate;

import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchedulesDTO {

	
	
	
	private Long _id;

   
    private ProjectsEntity project_id;
   	
    private ActivitiesEntity activity_id;
    private LocalDate baseline_start;
    private LocalDate basesline_end;
    private LocalDate actual_start;
    private LocalDate actual_end;
}
