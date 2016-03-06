package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TypeDeLit {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private Long id;
private String label;

@ManyToOne()
private TypeDeService typeDeService;

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

public TypeDeLit(String label) {
	super();
	this.label = label;
}

public TypeDeLit() {
	super();
	// TODO Auto-generated constructor stub
}


}
