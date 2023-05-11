package diplomaProjectManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomaProjectManager.dao.ApplicationDAO;
import diplomaProjectManager.dao.StudentDAO;
import diplomaProjectManager.dao.ThesisDAO;
import diplomaProjectManager.model.Application;
import diplomaProjectManager.model.Student;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private ThesisDAO thesisDAO;
	
	@Override
	public void saveProfile(Student student) {
		studentDAO.save(student);
	}

	@Override
	public Student retrieveProfile(String username) throws UsernameNotFoundException{
		return studentDAO.findByUsername(username).orElseThrow(
				()-> new UsernameNotFoundException(String.format("USER_NOT_FOUND", username))
		);
	}

	@Override
	public List<Subject> listStudentSubjects(String username) {
		return subjectService.findAll(username);
	}

	@Override
	public void applyToSubject(String username, int subjectId) {
		Application application = new Application();

    	Student student = retrieveProfile(username);
    	student.getApplications().add(application);
    	
    	Subject subject = subjectService.findById(subjectId);
    	subject.getApplications().add(application);
    	try {
    		applicationDAO.save(application);
    	} catch (DataIntegrityViolationException e) {} // catches duplicate apps
    	
	}

	@Override
	public Thesis getThesis(String username) {
		return thesisDAO.findByStudentUsername(username);
	}
}
