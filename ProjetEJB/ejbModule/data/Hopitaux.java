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
public class Hopitaux {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private Long id;
private String name;
private String Phone1;
private String Phone2;
private String Phone3;
private String Email;
private String Latitude;
private String Longitude;
//private TypeStructre typeStructure;
private String Adresse;

@ManyToOne()
private Zone zone;

@OneToMany(targetEntity=Agent.class,mappedBy="hopitaux",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@LazyCollection(LazyCollectionOption.FALSE)
private List<Agent> agents;

@OneToMany(targetEntity=Service.class,mappedBy="hopitaux",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@LazyCollection(LazyCollectionOption.FALSE)
private List<Service> services;

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

public String getPhone1() {
	return Phone1;
}

public void setPhone1(String phone1) {
	Phone1 = phone1;
}

public String getPhone2() {
	return Phone2;
}

public void setPhone2(String phone2) {
	Phone2 = phone2;
}

public String getPhone3() {
	return Phone3;
}

public void setPhone3(String phone3) {
	Phone3 = phone3;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getLatitude() {
	return Latitude;
}

public void setLatitude(String latitude) {
	Latitude = latitude;
}

public String getLongitude() {
	return Longitude;
}

public void setLongitude(String longitude) {
	Longitude = longitude;
}

public String getAdresse() {
	return Adresse;
}

public void setAdresse(String adresse) {
	Adresse = adresse;
}

public Hopitaux(String name) {
	super();
	this.name = name;
}

public Hopitaux() {
	super();
	// TODO Auto-generated constructor stub
}


}
