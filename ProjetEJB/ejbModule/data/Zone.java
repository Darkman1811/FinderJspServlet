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
public class Zone {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private Long id;
private String name;

@ManyToOne()
private Region region;

@OneToMany(targetEntity=Hopitaux.class,mappedBy="zone",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@LazyCollection(LazyCollectionOption.FALSE)
private List<Hopitaux> hopitaux;

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

public Zone(String name) {
	super();
	this.name = name;
}

public Zone() {
	super();
	// TODO Auto-generated constructor stub
}


}
