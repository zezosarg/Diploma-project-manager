package diplomaProjectManager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

	@Query(value = "SELECT * FROM users, applications WHERE application_id=1 AND user_id=student_id", nativeQuery = true)
	Student findByApplicationId(int applicationId);

	Optional<Student> findByUsername(String username);
	
}
