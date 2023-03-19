package diplomaProjectManager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")//change to students once mature
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name", unique=true)
	private String username;
	
	@Column(name="full_name")
	private String fullname;
	
	@Column(name="years_studying")
	private int yearsStudying;
	
	@Column(name="avg_grade")
	private double avgGrade;
	
	@Column(name="num_courses_left")
	private int numCoursesLeft;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Application> applications;

}