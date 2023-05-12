package diplomaProjectManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomaProjectManager.dao.ApplicationDAO;
import diplomaProjectManager.dao.ProfessorDAO;
import diplomaProjectManager.dao.SubjectDAO;
import diplomaProjectManager.dao.ThesisDAO;
import diplomaProjectManager.model.Application;
import diplomaProjectManager.model.BestApplicantStrategy;
import diplomaProjectManager.model.BestApplicantStrategyFactory;
import diplomaProjectManager.model.Professor;
import diplomaProjectManager.model.Student;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDAO professorDAO;
	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private ThesisDAO thesisDAO;
	@Autowired
	private BestApplicantStrategyFactory bestApplicantStrategyFactory;
	
	@Override
	public Professor retrieveProfile(String username) throws UsernameNotFoundException{
		return professorDAO.findByUsername(username).orElseThrow(
				()-> new UsernameNotFoundException(String.format("USER_NOT_FOUND", username))
		);
	}

	@Override
	public void saveProfile(Professor professor) {
		professorDAO.save(professor);
	}

	@Override
	public List<Subject> listProfessorSubjects(String username) {
		return subjectDAO.findByProfessorUsername(username);
	}

	@Override
	public Subject addSubject(String username) {
		Professor professor = retrieveProfile(username);
    	Subject subject = new Subject();
    	subject.setProfessor(professor);
    	return subject;
	}

	@Override
	public List<Application> listApplications(int subjectId) {
		return applicationDAO.findAvailableBySubjectId(subjectId);
	}

	@Override
	public List<Thesis> listProfessorTheses(String username) {
		return thesisDAO.findByProfessorUsername(username);
	}

	@Override
	public void assignSubject(String username, String strategyName, int subjectId) {
    	Thesis thesis = new Thesis();    	    	
    	Professor professor = retrieveProfile(username);
    	thesis.setProfessor(professor);
    	Subject subject = subjectDAO.findById(subjectId);
    	thesis.setSubject(subject);
    	BestApplicantStrategy strategy = bestApplicantStrategyFactory.createStrategy(strategyName);
    	Student student = strategy.findBestApplicant(applicationDAO.findAvailableBySubjectId(subject.getId()));//subject.getApplications());
    	if (student==null)
    		return;
    	thesis.setStudent(student);
    	thesisDAO.save(thesis);
	}

	@Override
	public Thesis retrieveThesis(int thesisId) {
		return thesisDAO.findById(thesisId);
	}

	@Override
	public void saveThesis(Thesis thesis) {
		thesisDAO.save(thesis);
	}
}
