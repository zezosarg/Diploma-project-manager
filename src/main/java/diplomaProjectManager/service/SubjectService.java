package diplomaProjectManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;

@Service
public interface SubjectService {
	
	void save(Subject subject);
	
	List<Subject> findAll();
	
	Subject findById(int id);

	void deleteById(int subjectId);

}