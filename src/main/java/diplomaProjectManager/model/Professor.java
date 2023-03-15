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
@Table(name="users")//change to professors once mature
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="user_name")
	private String name;
	
	@Column(name="specialty")
	private String specialty;
	
	@OneToMany(/*fetch = FetchType.EAGER,*/ cascade=CascadeType.ALL) //exception produced with fetches
	@JoinColumn(name="theses")
	private List<Thesis> theses;
	
	@OneToMany(/*fetch = FetchType.EAGER,*/ cascade=CascadeType.ALL)
	@JoinColumn(name="subjects")
	private List<Subject> subjects;

}