package diplomaProjectManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import diplomaProjectManager.model.Subject;

@Service
public interface SubjectService {
	
	void save(Subject subject);
	
	Subject findById(int id);

	void deleteById(int subjectId);

	List<Subject> findAll(String username);

}