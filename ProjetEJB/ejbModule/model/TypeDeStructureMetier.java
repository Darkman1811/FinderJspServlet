package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.TypeDeStructure;

@Stateless
public class TypeDeStructureMetier implements TypeDeStructureMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(TypeDeStructure typeDeStructure) {
		em.persist(typeDeStructure);	
	}

	@Override
	public List<TypeDeStructure> getAll() {
		Query req=em.createQuery("select T from TypeDeStructure T");
		return req.getResultList();

	}

	@Override
	public TypeDeStructure select(Long id) {
		TypeDeStructure tdst1=em.find(TypeDeStructure.class, id);
			return tdst1;
	}

	@Override
	public void update(TypeDeStructure tdst) {
		TypeDeStructure tdst1=(TypeDeStructure) em.find(TypeDeStructure.class, tdst.getId());
	    tdst1.setLabel(tdst.getLabel());
		em.persist(tdst1);
		
	}

	@Override
	public void delete(TypeDeStructure tdst) {
		em.remove(tdst);
		
	}

}
