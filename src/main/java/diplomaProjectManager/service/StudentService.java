package diplomaProjectManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import diplomaProjectManager.model.Student;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;

@Service
public interface StudentService {

	void saveProfile(Student student);
	
	Student retrieveProfile(String username);
	
	List<Subject> listStudentSubjects();
	
	void applyToSubject(String username, int subjectId);
	
	Thesis getThesis(String username);
	
}