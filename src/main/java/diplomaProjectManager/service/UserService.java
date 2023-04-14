package diplomaProjectManager.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import diplomaProjectManager.model.User;

@Service
public interface UserService {
	
	public void saveUser(User user);
	
    public boolean isUserPresent(User user);
    
    public Optional<User> findById(int id);
    
}
