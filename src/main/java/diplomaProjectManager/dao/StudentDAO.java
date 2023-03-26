package diplomaProjectManager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

	@Query("SELECT s FROM Student s, Application a WHERE a.id = ?1")
	Student findByApplicationId(int applicationId);

	Optional<Student> findByUsername(String username);
	
}
