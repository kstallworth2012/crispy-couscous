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
    
    
	public ProjectsEntity getProject_id() {
		return project_id;
	}
	public void setProject_id(ProjectsEntity project_id) {
		this.project_id = project_id;
	}
	public LocalDate getBaseline_start() {
		return baseline_start;
	}
	public void setBaseline_start(LocalDate baseline_start) {
		this.baseline_start = baseline_start;
	}
	public LocalDate getBasesline_end() {
		return basesline_end;
	}
	public void setBasesline_end(LocalDate basesline_end) {
		this.basesline_end = basesline_end;
	}
	public LocalDate getActual_start() {
		return actual_start;
	}
	public void setActual_start(LocalDate actual_start) {
		this.actual_start = actual_start;
	}
	public LocalDate getActual_end() {
		return actual_end;
	}
	public void setActual_end(LocalDate actual_end) {
		this.actual_end = actual_end;
	}
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
