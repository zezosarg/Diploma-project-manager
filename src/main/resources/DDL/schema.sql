CREATE DATABASE  IF NOT EXISTS `diploma_manager_db`;
USE `diploma_manager_db`;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `professors`;
DROP TABLE IF EXISTS `students`;
DROP TABLE IF EXISTS `subjects`;
DROP TABLE IF EXISTS `theses`;
DROP TABLE IF EXISTS `applications`;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `role` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `professors` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` text DEFAULT NULL,
	`specialty` text DEFAULT NULL,
	PRIMARY KEY (`id`)
)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `students` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` text DEFAULT NULL,
	`years_studying` int DEFAULT NULL,
	`avg_grade` double DEFAULT NULL,
	`num_courses_left` int DEFAULT NULL, 
	PRIMARY KEY (`id`)
)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `subjects` (
	`id` int NOT NULL AUTO_INCREMENT,
	`title` text DEFAULT NULL,
	`professor_id` int DEFAULT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_professor` FOREIGN KEY (`professor_id`) REFERENCES `professors` (`id`)
)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `theses` (
	`id` int NOT NULL AUTO_INCREMENT,
	`professor_id` int DEFAULT NULL,
	`subject_id` int DEFAULT NULL,
	`student_id` int DEFAULT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_professor` FOREIGN KEY (`professor_id`) REFERENCES `professors` (`id`),
	CONSTRAINT `fk_subject` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`), 
	CONSTRAINT `fk_student` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) 
)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `applications` (
	`id` int NOT NULL AUTO_INCREMENT,
	`subject_id` int DEFAULT NULL,
	`student_id` int DEFAULT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_subject` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`), 
	CONSTRAINT `fk_student` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`)
)	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
