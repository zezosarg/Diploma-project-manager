package diplomaProjectManager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Professor;

@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Integer>{

	Optional<Professor> findByUsername(String username);
	
}
