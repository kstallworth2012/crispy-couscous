package com.example.workflow.workmanagementapp.domain.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResourcesDTO {
	private UUID resource_id;
	private String resource_name;
	private String resource_type; 
	private String availability; 
	private Double cost_per_day;
	public UUID getResource_id() {
		return resource_id;
	}
	public void setResource_id(UUID resource_id) {
		this.resource_id = resource_id;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	} 
	
	
	
	
	
}
