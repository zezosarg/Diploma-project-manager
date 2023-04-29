package diplomaProjectManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Thesis;

@Repository
public interface ThesisDAO extends JpaRepository<Thesis, Integer> {

	@Query(value = "SELECT * FROM theses JOIN users ON professor_id=user_id WHERE user_name=?1", nativeQuery = true)
	List<Thesis> findByProfessorUsername(String username);

	@Query(value = "SELECT * FROM theses JOIN users ON student_id=user_id WHERE user_name=?1", nativeQuery = true)
	Thesis findByStudentUsername(String username);	
	
	Thesis findById(int id);
}
