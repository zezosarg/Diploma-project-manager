package diplomaProjectManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomaProjectManager.dao.SubjectDAO;
import diplomaProjectManager.model.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;

	@Override
	@Transactional
	public void save(Subject subject) {
		subjectDAO.save(subject);
	}

	@Override
	@Transactional
	public void deleteById(int subjectId) {
		subjectDAO.deleteById(subjectId);
	}
	
	@Override
	@Transactional
	public List<Subject> findAll() {
		return subjectDAO.findAvailable();
	}

	@Override
	@Transactional
	public Subject findById(int id) {
		return subjectDAO.findById(id);
	}
}
