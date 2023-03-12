package diplomaProjectManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

//	@Query("SELECT u FROM student u WHERE u.application_id = ?1")
//	Student findByApplication(int appId);
	
}
