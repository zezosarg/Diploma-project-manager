package diplomaProjectManager.model;

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
	private Float overallGrade;
	
	@Column(name="implementation_grade")
	private Float implementationGrade;
	
	@Column(name="report_grade")
	private Float reportGrade;	
	
	@Column(name="presentation_grade")
	private Float presentationGrade;
	
	@OneToOne
    @JoinColumn(name = "subject_id")
	private Subject subject;
	
	@OneToOne
    @JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;

	public void calculateGrade() {
		if (!(this.implementationGrade.equals(null)||this.reportGrade.equals(null)||this.presentationGrade.equals(null)))
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

	public Float getOverallGrade() {
		return overallGrade;
	}

	public void setOverallGrade(Float overallGrade) {
		this.overallGrade = overallGrade;
	}

	public Float getImplementationGrade() {
		return implementationGrade;
	}

	public void setImplementationGrade(Float implementationGrade) {
		this.implementationGrade = implementationGrade;
	}

	public Float getReportGrade() {
		return reportGrade;
	}

	public void setReportGrade(Float reportGrade) {
		this.reportGrade = reportGrade;
	}

	public Float getPresentationGrade() {
		return presentationGrade;
	}

	public void setPresentationGrade(Float presentationGrade) {
		this.presentationGrade = presentationGrade;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}