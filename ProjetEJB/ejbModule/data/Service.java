package data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Service {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private Long id;
private String name;
private String numPhoneInterne;


@ManyToOne()
private Hopitaux hopitaux;

@ManyToOne()
private Agent agent;

@OneToMany(targetEntity=Lit.class,mappedBy="service",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@LazyCollection(LazyCollectionOption.FALSE)
private List<Lit> lits;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getNumPhoneInterne() {
	return numPhoneInterne;
}

public void setNumPhoneInterne(String numPhoneInterne) {
	this.numPhoneInterne = numPhoneInterne;
}

public Service(String name) {
	super();
	this.name = name;
}

public Service() {
	super();
	// TODO Auto-generated constructor stub
}


}
