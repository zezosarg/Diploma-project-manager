package diplomaProjectManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import diplomaProjectManager.model.Student;
import diplomaProjectManager.model.Subject;

@Service
public interface StudentService {

	void saveProfile(Student student);
	
	Student retrieveProfile(String string);
	
	List<Subject> listStudentSubjects();
	
	void applyToSubject(String string, Integer integer);
	
}