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
@Table(name = "Schedules")
public class SchedulesEntity{
	@Id
	private Long _id;

/*
    ProjectEntity project_id;
   	ActivitiesEntity activity_id;
    LocalDate baseline_start;
    LocalDate baseline_end;
    LocalDate actual_start;
    LocalDate actual_end;
*/

/*
CREATE TABLE Schedules (
    schedule_id INT PRIMARY KEY,
    project_id INT,
    activity_id INT,
    baseline_start DATE,
    baseline_end DATE,
    actual_start DATE,
    actual_end DATE,
    FOREIGN KEY (project_id) REFERENCES Projects(project_id),
    FOREIGN KEY (activity_id) REFERENCES Activities(activity_id)
);

-- Sample data
INSERT INTO Schedules VALUES
(1, 1, 1, '2024-01-01', '2024-01-05', '2024-01-05', '2024-01-10'),
(2, 1, 2, '2024-02-01', '2024-02-28', '2024-02-01', NULL);

*/



	/*

Establish Relationships
Next, let's clarify the relationships between these entities:

One project can have many activities (1-to-Many).
One project can have many teams (1-to-Many).
One team can consist of many resources (Many-to-Many).
Each activity can have many assignments (1-to-Many).
Each activity has one schedule (1-to-1).
	*/



	/*


	Query 1: List All Activities and Their Status

SELECT activity_name, status, percent_complete
FROM Activities;


Query 2: Get All Active Projects and Their Managers
SELECT project_name, project_manager
FROM Projects
WHERE status = 'In Progress'; 



Query 3: View Resource Allocation for a Project
SELECT r.resource_name, r.resource_type, a.activity_name, ass.role
FROM Resources r
JOIN Assignments ass ON r.resource_id = ass.resource_id
JOIN Activities a ON a.activity_id = ass.activity_id
WHERE ass.project_id = 1;



Query 4: Track Delayed Activities

SELECT a.activity_name, s.baseline_end, s.actual_end
FROM Activities a
JOIN Schedules s ON a.activity_id = s.activity_id
WHERE s.actual_end IS NULL OR s.actual_end > s.baseline_end;

	*/
}