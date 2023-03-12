package diplomaProjectManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import diplomaProjectManager.model.Application;
import diplomaProjectManager.model.Professor;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;

@Service
public interface ProfessorService {

	Professor retrieveProfile(String string);
	
	void saveProfile(Professor professor);
	
	List<Subject> listProfessorSubjects(String string);
	
	void addSubject(String string, Subject subject);
	
	List<Application> listApplications(String string, Integer integer);
	
	List<Thesis> listProfessorTheses(String string);
	
	void assignSubject(String string, Integer integer);
	
}