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
public class TypeDeService {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private Long id;
private String label;

@ManyToOne()
private TypeDeStructure typeDeStructure;

@OneToMany(targetEntity=TypeDeLit.class,mappedBy="typeDeService",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@LazyCollection(LazyCollectionOption.FALSE)
private List<TypeDeLit> typeDeLits;


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

public TypeDeService(String label) {
	super();
	this.label = label;
}

public TypeDeService() {
	super();
	// TODO Auto-generated constructor stub
}


}
