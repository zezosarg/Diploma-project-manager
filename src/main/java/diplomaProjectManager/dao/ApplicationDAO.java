package diplomaProjectManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Application;

@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer>{

	@Query("SELECT a FROM Application a, Subject s WHERE s.id = ?1")
	List<Application> findBySubject(int subjectId);

}