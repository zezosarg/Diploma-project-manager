package diplomaProjectManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Subject;

@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer>{

	@Query(value="SELECT * FROM subjects JOIN users ON professor_id=user_id WHERE user_name=?1 AND subject_id NOT IN (SELECT subject_id FROM theses)", nativeQuery=true)
	List<Subject> findByProfessorUsername(String username);
	
	@Query(value="SELECT * FROM subjects WHERE subject_id NOT IN (SELECT subject_id FROM theses) AND subject_id NOT IN (SELECT subject_id FROM applications TODO)", nativeQuery=true)//TODO
	List<Subject> findAvailableUnappliedByStudentId(int id);
	
	Subject findById(int subjectId);
}