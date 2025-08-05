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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Projects")
public class ProjectsEntity{
	@Id
	private Long _id;
	/*
		CREATE TABLE Projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(255),
    project_manager VARCHAR(100),
    start_date DATE,
    end_date DATE,
    status VARCHAR(50)
);

-- Sample data
INSERT INTO Projects VALUES
(1, 'Office Renovation', 'Alice Thompson', '2024-01-01', '2024-12-31', 'In Progress'),
(2, 'IT Upgrade', 'Bob Singh', '2024-02-15', '2024-09-30', 'Completed');
	*/

}