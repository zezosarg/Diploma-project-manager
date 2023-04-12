package diplomaProjectManager.model;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="theses")
public class Thesis { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="thesis_id")
	private int id;
	
	@Column(name="overall_grade")
	private float overallGrade;
	
	@Column(name="implementation_grade")
	private float implementationGrade;
	
	@Column(name="report_grade")
	private float reportGrade;	
	
	@Column(name="presentation_grade")
	private float presentationGrade;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "subject_id")
	private Subject subject;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="professor_id")
	private Professor professor;

	public void calculateGrade() {
		this.overallGrade = (float) ((0.7) * this.implementationGrade + (0.15) * this.reportGrade + (0.15) * this.presentationGrade);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public float getOverallGrade() {
		return overallGrade;
	}

	public void setOverallGrade(float overallGrade) {
		this.overallGrade = overallGrade;
	}

	public float getImplementationGrade() {
		return implementationGrade;
	}

	public void setImplementationGrade(float implementationGrade) {
		this.implementationGrade = implementationGrade;
	}

	public float getReportGrade() {
		return reportGrade;
	}

	public void setReportGrade(float reportGrade) {
		this.reportGrade = reportGrade;
	}

	public float getPresentationGrade() {
		return presentationGrade;
	}

	public void setPresentationGrade(float presentationGrade) {
		this.presentationGrade = presentationGrade;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}