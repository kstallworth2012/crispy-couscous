package com.example.workflow.workmanagementapp.domain.dto;

import java.time.LocalDate;
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
public class ActivitiesDTO {
	private UUID  Id;


	private ProjectsEntity project_id;
    private String activity_name; 
    private LocalDate start_date;
    private LocalDate end_date;
    private String status;
    private Integer total_float;
    private String percent_complete;
    
    
    
    public ProjectsEntity getProject_id() {
		return project_id;
	}
	public void setProject_id(ProjectsEntity project_id) {
		this.project_id = project_id;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTotal_float() {
		return total_float;
	}
	public void setTotal_float(Integer total_float) {
		this.total_float = total_float;
	}
	public String getPercent_complete() {
		return percent_complete;
	}
	public void setPercent_complete(String percent_complete) {
		this.percent_complete = percent_complete;
	}
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
    
    
    
    
    
    
    
    
    
    
}
