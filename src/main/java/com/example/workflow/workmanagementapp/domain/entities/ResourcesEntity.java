package com.example.workflow.workmanagementapp.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Resources")
public class ResourcesEntity{
	@Id
	//@Column(name = "id", columnDefinition = "UUID")
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
	public String getResource_type() {
		return resource_type;
	}
	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Double getCost_per_day() {
		return cost_per_day;
	}
	public void setCost_per_day(Double cost_per_day) {
		this.cost_per_day = cost_per_day;
	}
	
	
	
	
	
/*
CREATE TABLE Resources (
    resource_id INT PRIMARY KEY,
    resource_name VARCHAR(255),
    resource_type VARCHAR(50),
    availability VARCHAR(10),
    cost_per_day DECIMAL(10, 2)
);

-- Sample data
INSERT INTO Resources VALUES
(1, 'John Smith', 'Labor', '100%', 200),
(2, 'Excavator','Labor','90%',900)
*/

}