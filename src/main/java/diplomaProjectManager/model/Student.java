package diplomaProjectManager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name="user_id")
	private int id;
	
	@Column(name="user_name", unique=true)
	private String username;
	
	@Column(name="password")
	private String password;

	@Enumerated(EnumType.STRING)
    @Column(name="role")
	private Role role;
	
	@Column(name="full_name")
	private String fullname;
	
	@Column(name="years_studying")
	private Integer yearsStudying;	//using wrapper class of int to allow null value
	
	@Column(name="avg_grade")
	private Float avgGrade;
	
	@Column(name="num_courses_left")
	private Integer numCoursesLeft;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL/*, mappedBy="student"*/)
	@JoinColumn(name = "student_id")
	private List<Application> applications;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getYearsStudying() {
		return yearsStudying;
	}

	public void setYearsStudying(Integer yearsStudying) {
		this.yearsStudying = yearsStudying;
	}

	public Float getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(Float avgGrade) {
		this.avgGrade = avgGrade;
	}

	public Integer getNumCoursesLeft() {
		return numCoursesLeft;
	}

	public void setNumCoursesLeft(Integer numCoursesLeft) {
		this.numCoursesLeft = numCoursesLeft;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}