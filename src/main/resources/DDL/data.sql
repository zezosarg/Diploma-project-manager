USE `dpm`;

INSERT INTO users (user_id, user_name, password, role, full_name, specialty)
VALUES (2, 'zas', '$2a$10$mXdJ0RsumuYaoHdNrqB8xud.3l1gupo1G4iyPMrcpkcG/VMSqqGW2', 'PROFESSOR', 'Apostolos Zarras', 'Software Engineering');

INSERT INTO users (user_id, user_name, password, role, full_name, years_studying, avg_grade, num_courses_left)
VALUES (1, 'rgz', '$2a$10$4ZZIbTuIpHAHzJuT5hyNpe8j72EK/ZAxzEB551c0.hR.vz9tKRL5C', 'STUDENT', 'Argyrios Zezos', 5, 7.01, 14);

INSERT INTO subjects (subject_id, title, objectives, professor_id)
VALUES (1, 'Bus app', 'Create an application to diplay bus route info', 2);

INSERT INTO applications (application_id, subject_id, student_id)
VALUES (1, 1, 1);

#INSERT INTO theses (thesis_id, professor_id, subject_id, student_id)
#VALUES (1, 2, 1, 1);