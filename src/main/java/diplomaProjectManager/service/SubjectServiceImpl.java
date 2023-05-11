package diplomaProjectManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomaProjectManager.dao.SubjectDAO;
import diplomaProjectManager.model.Subject;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;

	@Override
	public void save(Subject subject) {
		subjectDAO.save(subject);
	}

	@Override
	public void deleteById(int subjectId) {
		subjectDAO.deleteById(subjectId);
	}
	
	@Override
	public List<Subject> findAll(String username) {
		return subjectDAO.findAvailableByStudentUsername(username);
	}

	@Override
	public Subject findById(int id) {
		return subjectDAO.findById(id);
	}

}
