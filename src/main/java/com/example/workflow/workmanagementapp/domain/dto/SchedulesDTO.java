package com.example.workflow.workmanagementapp.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

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

	
	
	
	private UUID _id;

   
    private ProjectsEntity project_id;
   	
    private ActivitiesEntity activity_id;
    private LocalDate baseline_start;
    private LocalDate basesline_end;
    private LocalDate actual_start;
    private LocalDate actual_end;
	public UUID get_id() {
		return _id;
	}
	public void set_id(UUID _id) {
		this._id = _id;
	}
	public ActivitiesEntity getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(ActivitiesEntity activity_id) {
		this.activity_id = activity_id;
	}
    
    
    
    
}
