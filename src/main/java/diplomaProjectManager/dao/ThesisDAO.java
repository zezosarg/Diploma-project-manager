package diplomaProjectManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Thesis;

@Repository
public interface ThesisDAO extends JpaRepository<Thesis, Integer>{

	@Query("SELECT t FROM Thesis t, Professor p WHERE p.username = ?1")
	List<Thesis> findByProfessorUsername(String username);

}
