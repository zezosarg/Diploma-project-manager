package diplomaProjectManager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import diplomaProjectManager.model.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);

}
