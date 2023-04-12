package diplomaProjectManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Application;

@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer>{

	@Query(value = "SELECT * FROM applications AS a JOIN subjects AS s ON a.subject_id=s.subject_id WHERE a.subject_id=?1", nativeQuery=true)
	List<Application> findBySubject(int subjectId);

}