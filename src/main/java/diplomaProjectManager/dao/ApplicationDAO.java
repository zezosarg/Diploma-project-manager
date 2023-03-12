package diplomaProjectManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diplomaProjectManager.model.Application;

@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer>{

}