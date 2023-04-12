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
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDAO professorDAO;
	@Autowired
	private SubjectDAO subjectDAO;	//is this good design?//should this be delegated to subject service?
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private ThesisDAO thesisDAO;
	@Autowired
	private BestApplicantStrategyFactory bestApplicantStrategyFactory;
	
	@Override
	@Transactional
	public Professor retrieveProfile(String username) throws UsernameNotFoundException{
		return professorDAO.findByUsername(username).orElseThrow(
				()-> new UsernameNotFoundException(String.format("USER_NOT_FOUND", username))
		);
	}

	@Override
	@Transactional
	public void saveProfile(Professor professor) {
		professorDAO.save(professor);
	}

	@Override
	@Transactional
	public List<Subject> listProfessorSubjects(String username) {
		return subjectDAO.findByProfessorUsername(username);
	}

	@Override
	@Transactional
	public void addSubject(String string, Subject subject) {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public List<Application> listApplications(/*String string, */int subjectId) {
		return applicationDAO.findBySubject(subjectId);
	}

	@Override
	@Transactional
	public List<Thesis> listProfessorTheses(String username) {
		return thesisDAO.findByProfessorUsername(username);
	}

	@Override
	@Transactional
	public void assignSubject(String username, String strategyName, int subjectId) {
    	Thesis thesis = new Thesis();    	    	
    	Professor professor = retrieveProfile(username);
    	thesis.setProfessor(professor);
    	Subject subject = subjectDAO.findById(subjectId);
    	thesis.setSubject(subject);
    	BestApplicantStrategy strategy = bestApplicantStrategyFactory.createStrategy(strategyName);
    	Student student = strategy.findBestApplicant(subject.getApplications());
    	thesis.setStudent(student);
    	thesisDAO.save(thesis);
	}

	@Override
	@Transactional
	public Thesis retrieveThesis(int thesisId) {
		return thesisDAO.findById(thesisId);
	}

	@Override
	@Transactional
	public void saveThesis(Thesis thesis) {
		thesisDAO.save(thesis);
	}
}
