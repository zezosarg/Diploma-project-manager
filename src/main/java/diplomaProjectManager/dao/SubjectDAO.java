package diplomaProjectManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Subject;

@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer>{
	
}