
CREATE TABLE Projects (
    project_id UUID PRIMARY KEY,
    project_name VARCHAR(255),
    project_manager VARCHAR(100),
    start_date DATE,
    end_date DATE,
    status VARCHAR(50)
);

-- Sample data
INSERT INTO Projects VALUES
('c3fdd9d8-7061-4abc-a669-8fee52248abd', 'Office Renovation', 'Alice Thompson', '2024-01-01', '2024-12-31', 'In Progress'),
('23a87665-37c8-4767-89f1-09c94f125626', 'IT Upgrade', 'Bob Singh', '2024-02-15', '2024-09-30', 'Completed');

CREATE TABLE Activities (
    activity_id UUID PRIMARY KEY,
    project_id UUID,
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
('07ec7c35-8b7b-4fb6-8fc4-167b3e733593', 'c3fdd9d8-7061-4abc-a669-8fee52248abd', 'Site Survey', '2024-01-05', '2024-01-10', 'Completed', 5, '100%'),
('012e3c64-e593-4818-a724-e2dfadc4a7d6', 'c3fdd9d8-7061-4abc-a669-8fee52248abd', 'Electrical Work', '2024-02-01', '2024-03-01', 'In Progress', 10, '75%');




--
CREATE TABLE Resources (
    resource_id UUID PRIMARY KEY,
    resource_name VARCHAR(255),
    resource_type VARCHAR(50),
    availability VARCHAR(10),
    cost_per_day DECIMAL(10, 2)
);


INSERT INTO Resources VALUES
('ba84b149-4428-4c24-8f6e-8f6f309ae0b2', 'John Smith', 'Labor', '100%', 200),
('01f08236-74b0-40a5-8758-343cfae57e0f', 'Excavator','Labor','90%',900)

--
--
--
--
--CREATE TABLE Schedules (
--    schedule_id UUID PRIMARY KEY,
--    project_id UUID,
--    activity_id UUID,
--    baseline_start DATE,
--    baseline_end DATE,
--    actual_start DATE,
--    actual_end DATE,
--    FOREIGN KEY (project_id) REFERENCES Projects(project_id),
--    FOREIGN KEY (activity_id) REFERENCES Activities(activity_id)
--);
--
---- Sample data
--INSERT INTO Schedules VALUES
--(1, 1, 1, '2024-01-01', '2024-01-05', '2024-01-05', '2024-01-10'),
--(2, 1, 2, '2024-02-01', '2024-02-28', '2024-02-01', NULL);
--
--CREATE TABLE Teams (
--    team_id INT PRIMARY KEY,
--    team_name VARCHAR(255),
--    team_lead VARCHAR(100),
--    project_id INT,
--    FOREIGN KEY (project_id) REFERENCES Projects(project_id)
--);
--
---- Sample data
--INSERT INTO Teams VALUES
--(1, 'Electrical Team', 'Jane Doe', 1),
--(2, 'IT Inference Team, 'Bob Holis',2)
