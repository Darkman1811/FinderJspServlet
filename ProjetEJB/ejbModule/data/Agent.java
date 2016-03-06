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
public class Agent {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private Long id;
private String prenom;
private String nom;
private String phone;
private String email;
private String adresse;

@ManyToOne()
private Hopitaux hopitaux;


@OneToMany(targetEntity=Service.class,mappedBy="agent",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@LazyCollection(LazyCollectionOption.FALSE)
private List<Service> services;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


public Agent(String nom) {
	super();
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public Agent() {
	super();
	// TODO Auto-generated constructor stub
}


}
