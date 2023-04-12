DROP DATABASE dpm;
CREATE DATABASE  IF NOT EXISTS `dpm`;
USE `dpm`;

#DROP TABLE IF EXISTS `users`;
#DROP TABLE IF EXISTS `subjects`;
#DROP TABLE IF EXISTS `theses`;
#DROP TABLE IF EXISTS `applications`;

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `role` text DEFAULT NULL,
  `full_name` text DEFAULT NULL,
  `specialty` text DEFAULT NULL,
  `years_studying` int DEFAULT NULL,
  `avg_grade` double DEFAULT NULL,
  `num_courses_left` int DEFAULT NULL, 
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `subjects` (
	`subject_id` int NOT NULL AUTO_INCREMENT,
	`title` text DEFAULT NULL,
	`objectives` text DEFAULT NULL,
	`professor_id` int DEFAULT NULL,
	PRIMARY KEY (`subject_id`),
	CONSTRAINT `fk_subject_professor` FOREIGN KEY (`professor_id`) REFERENCES `users` (`user_id`)
)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `theses` (
	`thesis_id` int NOT NULL AUTO_INCREMENT,
	`overall_grade` float DEFAULT NULL,
	`implementation_grade` float DEFAULT NULL,
	`report_grade` float DEFAULT NULL,
	`presentation_grade` float DEFAULT NULL,
	`professor_id` int DEFAULT NULL,
	`subject_id` int DEFAULT NULL,
	`student_id` int DEFAULT NULL,
	PRIMARY KEY (`thesis_id`),
	CONSTRAINT `fk_thesis_professor` FOREIGN KEY (`professor_id`) REFERENCES `users` (`user_id`),
	CONSTRAINT `fk_thesis_subject` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`), 
	CONSTRAINT `fk_thesis_student` FOREIGN KEY (`student_id`) REFERENCES `users` (`user_id`) 
)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `applications` (
	`application_id` int NOT NULL AUTO_INCREMENT,
	`subject_id` int DEFAULT NULL,
	`student_id` int DEFAULT NULL,
	PRIMARY KEY (`application_id`),
	CONSTRAINT `fk_application_subject` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`), 
	CONSTRAINT `fk_application_student` FOREIGN KEY (`student_id`) REFERENCES `users` (`user_id`),
	CONSTRAINT uq_applications UNIQUE(subject_id, student_id)
)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# initially will use table users for both students and professors with unused fields set to null

#DROP TABLE IF EXISTS `professors`;
#DROP TABLE IF EXISTS `students`;

#CREATE TABLE `professors` (
#	`id` int NOT NULL AUTO_INCREMENT,
#	`name` text DEFAULT NULL,
#	`specialty` text DEFAULT NULL,
#	PRIMARY KEY (`id`)
#)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
#
#CREATE TABLE `students` (
#	`id` int NOT NULL AUTO_INCREMENT,
#	`name` text DEFAULT NULL,
#	`years_studying` int DEFAULT NULL,
#	`avg_grade` double DEFAULT NULL,
#	`num_courses_left` int DEFAULT NULL, 
#	PRIMARY KEY (`id`)
#)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;