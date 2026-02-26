package com.example.workflow.workmanagementapp.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Teams")
public class TeamsEntity{
	@Id
	private UUID team_id;


	private String team_name;
    private String team_lead; 
    
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectsEntity project_id; 
    
    
    public UUID getTeam_id() {
		return team_id;
	}

	public void setTeam_id(UUID team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public ProjectsEntity getProject_id() {
		return project_id;
	}

	public void setProject_id(ProjectsEntity project_id) {
		this.project_id = project_id;
	}

/*

CREATE TABLE Teams (
    team_id INT PRIMARY KEY,
    team_name VARCHAR(255),
    team_lead VARCHAR(100),
    project_id INT,
    FOREIGN KEY (project_id) REFERENCES Projects(project_id)
);

-- Sample data
INSERT INTO Teams VALUES
(1, 'Electrical Team', 'Jane Doe', 1),
(2, 'IT Inf

*/

}