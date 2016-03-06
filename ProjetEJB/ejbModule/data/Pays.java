package data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Pays {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private Long id;
private String name;
@OneToMany(targetEntity=Region.class,mappedBy="pays",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
 @LazyCollection(LazyCollectionOption.FALSE)
private List<Region> regions;

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

public List <Region> getRegions() {
	return regions;
}

public void setRegions(List <Region> regions) {
	this.regions = regions;
}

public Pays(String name) {
	super();
	this.name = name;
}

public Pays() {
	super();
	// TODO Auto-generated constructor stub
}


}
