package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lit {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private Long id;
private String label;
private String numeroImmobilisation;
private String etat;

@ManyToOne()
private Service service;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public String getNumeroImmobilisation() {
	return numeroImmobilisation;
}

public void setNumeroImmobilisation(String numeroImmobilisation) {
	this.numeroImmobilisation = numeroImmobilisation;
}

public String getEtat() {
	return etat;
}

public void setEtat(String etat) {
	this.etat = etat;
}

public Lit(String label) {
	super();
	this.label = label;
}

public Lit() {
	super();
	// TODO Auto-generated constructor stub
}


}
