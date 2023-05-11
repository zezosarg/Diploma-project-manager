package diplomaProjectManager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

	@Query(value = "SELECT * FROM users JOIN applications ON user_id=student_id WHERE application_id=?1", nativeQuery = true)
	Student findAvailableByApplicationId(int applicationId);

	Optional<Student> findByUsername(String username);

}
