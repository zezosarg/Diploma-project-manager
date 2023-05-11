USE `dpm`;

INSERT INTO users 
	(user_id, user_name, password, role, full_name, specialty)
VALUES
	(1, 'zas', '$2a$10$mXdJ0RsumuYaoHdNrqB8xud.3l1gupo1G4iyPMrcpkcG/VMSqqGW2', 'PROFESSOR', 'Apostolos Zarras', 'Software Engineering'),
	(2, 'pv', '$2a$10$mXdJ0RsumuYaoHdNrqB8xud.3l1gupo1G4iyPMrcpkcG/VMSqqGW2', 'PROFESSOR', 'Panos Vassiliadis', 'Databases');

INSERT INTO users
	(user_id, user_name, password, role, full_name, years_studying, avg_grade, num_courses_left)
VALUES
	(3, 'rgz', '$2a$10$4ZZIbTuIpHAHzJuT5hyNpe8j72EK/ZAxzEB551c0.hR.vz9tKRL5C', 'STUDENT', 'Argyrios Zezos', 5, 8, 14),
	(4, 'ofwtios', '$2a$10$4ZZIbTuIpHAHzJuT5hyNpe8j72EK/ZAxzEB551c0.hR.vz9tKRL5C', 'STUDENT', 'Fwtios Pappas', 4, 9, 15),
	(5, 'liakos', '$2a$10$4ZZIbTuIpHAHzJuT5hyNpe8j72EK/ZAxzEB551c0.hR.vz9tKRL5C', 'STUDENT', 'Hlias Dhmopoylos', 4, 10, 1);

INSERT INTO subjects
	(subject_id, title, objectives, professor_id)
VALUES
	(1, 'Taxpayer Manager', 'Refactor a legacy application', 1),
	(2, 'Diploma project manager', 'Create a Spring Boot web application', 1),
	(3, 'Gantt Manager', 'Implement the backend of a java application', 2),
	(4, 'Data visualizer', 'Create a web app on top of a database made out of raw data', 2);

INSERT INTO applications
	(application_id, subject_id, student_id)
VALUES
	(1, 1, 3), (9, 2, 3), (2, 3, 3), (3, 4, 3),
	(4, 1, 4), (5, 2, 4), (6, 3, 4),
	(7, 2, 5), (8, 3, 5);

INSERT INTO theses
	(thesis_id, overall_grade, implementation_grade, report_grade, presentation_grade, professor_id, subject_id, student_id)
VALUES
	(1, -1, -1, -1, -1, 1, 2, 3);