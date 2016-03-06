package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.TypeDeLit;

@Stateless
public class TypeDeLitMetier implements TypeDeLitMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(TypeDeLit typeDeLit) {
		em.persist(typeDeLit);	
	}

	@Override
	public List<TypeDeLit> getAll() {
		Query req=em.createQuery("select T from TypeDeLit T");
		return req.getResultList();

	}

	@Override
	public TypeDeLit select(Long id) {
		TypeDeLit tdl1=em.find(TypeDeLit.class, id);
			return tdl1;
	}

	@Override
	public void update(TypeDeLit tdl) {
		TypeDeLit tdl1=(TypeDeLit) em.find(TypeDeLit.class, tdl.getId());
	    tdl1.setLabel(tdl.getLabel());
		em.persist(tdl1);
		
	}

	@Override
	public void delete(TypeDeLit tdl) {
		em.remove(tdl);
		
	}

}
