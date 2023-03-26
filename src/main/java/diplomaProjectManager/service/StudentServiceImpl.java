package diplomaProjectManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomaProjectManager.dao.ProfessorDAO;
import diplomaProjectManager.dao.StudentDAO;
import diplomaProjectManager.dao.SubjectDAO;
import diplomaProjectManager.model.Professor;
import diplomaProjectManager.model.Student;
import diplomaProjectManager.model.Subject;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private SubjectService subjectService;
	
	@Override
	@Transactional
	public void saveProfile(Student student) {
		studentDAO.save(student);
	}

	@Override
	@Transactional
	public Student retrieveProfile(String username) throws UsernameNotFoundException{
		return studentDAO.findByUsername(username).orElseThrow(
				()-> new UsernameNotFoundException(String.format("USER_NOT_FOUND", username))
		);
	}

	@Override
	@Transactional
	public List<Subject> listStudentSubjects() {
		return subjectService.findAll();
	}

	@Override
	public void applyToSubject(String string, Integer integer) {
		// TODO Auto-generated method stub

	}

}
