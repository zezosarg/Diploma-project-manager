package diplomaProjectManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import diplomaProjectManager.model.Application;
import diplomaProjectManager.model.Professor;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;

@Service
public interface ProfessorService {

	Professor retrieveProfile(String username);
	
	void saveProfile(Professor professor);
	
	List<Subject> listProfessorSubjects(String username);
	
	Subject addSubject(String username);
	
	List<Thesis> listProfessorTheses(String username);
	
	void assignSubject(String username, String strategy, int subjectId, int...threshold);
		
	List<Application> listApplications(int subjectId);
	
	Thesis retrieveThesis(int thesisId);

	void saveThesis(Thesis thesis);
}