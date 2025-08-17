package com.example.workflow.workmanagementapp.domain.entities;



import com.example.workflow.workmanagementapp.domain.entities.ActivitiesEntity;
import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;
import com.example.workflow.workmanagementapp.domain.entities.ResourcesEntity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Assignments")
public class AssignmentsEntity{
	@Id
	private Long assignment_id;
	
//    @JoinColumn
    private ProjectsEntity project_id;
    
//    @JoinColumn
    private ActivitiesEntity activity_id;
    
//    @JoinColumn
    private ResourcesEntity resource_id;
    private String role;

/*

CREATE TABLE Assignments (
    assignment_id INT PRIMARY KEY,
    project_id INT,
    activity_id INT,
    resource_id INT,
    role VARCHAR(100),
    FOREIGN KEY (project_id) REFERENCES Projects(project_id),
    FOREIGN KEY (activity_id) REFERENCES Activities(activity_id),
    FOREIGN KEY (resource_id) REFERENCES Resources(resource_id)
);

-- Sample data
INSERT INTO Assignments VALUES
(1, 1, 2, 1, 'Electrician'),
(2, 2, 3, 1, 'IT Specialist');
*/
}