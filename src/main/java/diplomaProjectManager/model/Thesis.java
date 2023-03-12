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
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "subject_id")
	private Subject subject;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="professor_id")
	private Professor professor;

}
