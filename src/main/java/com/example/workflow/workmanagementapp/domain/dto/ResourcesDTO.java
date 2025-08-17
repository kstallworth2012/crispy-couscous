package com.example.workflow.workmanagementapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResourcesDTO {
	private Long resource_id;
	private String resource_name;
	private String resource_type; 
	private String availability; 
	private Double cost_per_day; 
}
