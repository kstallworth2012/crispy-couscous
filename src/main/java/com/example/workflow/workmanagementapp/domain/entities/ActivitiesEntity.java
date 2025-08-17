package com.example.workflow.workmanagementapp.domain.entities;


import com.example.workflow.workmanagementapp.domain.entities.ProjectsEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.CascadeType;
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
@Table(name = "activities")
public class ActivitiesEntity{
	@Id
	private Long activity_id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectsEntity project_id;
    private String activity_name; 
    private LocalDate start_date;
    private LocalDate end_date;
    private String status;
    private Integer total_float;
    private Double percent_complete;
    

/*
CREATE TABLE Activities (
    activity_id INT PRIMARY KEY,
    project_id INT,
    activity_name VARCHAR(255),
    start_date DATE,
    end_date DATE,
    status VARCHAR(50),
    total_float INT,
    percent_complete VARCHAR(10),
    FOREIGN KEY (project_id) REFERENCES Projects(project_id)
);

-- Sample data
INSERT INTO Activities VALUES
(1, 1, 'Site Survey', '2024-01-05', '2024-01-10', 'Completed', 5, '100%'),
(2, 1, 'Electrical Work', '2024-02-01', '2024-03-01', 'In Progress', 10, '75%');
*/

	}