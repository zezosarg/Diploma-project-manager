package diplomaProjectManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Thesis;

@Repository
public interface ThesisDAO extends JpaRepository<Thesis, Integer>{

	@Query(value = "SELECT * FROM theses AS t JOIN users AS p ON t.professor_id=p.user_id WHERE p.user_name=?1", nativeQuery = true)
	List<Thesis> findByProfessorUsername(String username);

	Thesis findById(int id);
}
