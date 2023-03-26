package diplomaProjectManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Subject;

@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer>{

	@Query("SELECT s FROM Subject s, Professor p WHERE p.username = ?1") // TODO AND s NOT IN (Thesis) OR delete subjects on assignment
	List<Subject> findByProfessorUsername(String username);
	
}