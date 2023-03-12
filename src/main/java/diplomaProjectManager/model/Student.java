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
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="years_studying")
	private int yearsStudying;
	
	@Column(name="avg_grade")
	private double avgGrade;
	
	@Column(name="num_courses_left")
	private int numCoursesLeft;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="application_id")
	private List<Application> applications;

//	public double getAvgGrade() {
//		return avgGrade;
//	}
//
//	public int getNumCoursesLeft() {
//		return numCoursesLeft;
//	}
}