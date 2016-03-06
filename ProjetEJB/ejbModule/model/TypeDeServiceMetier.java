package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.TypeDeService;

@Stateless
public class TypeDeServiceMetier implements TypeDeServiceMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(TypeDeService typeDeService) {
		em.persist(typeDeService);	
	}

	@Override
	public List<TypeDeService> getAll() {
		Query req=em.createQuery("select T from TypeDeService T");
		return req.getResultList();

	}

	@Override
	public TypeDeService select(Long id) {
		TypeDeService tds1=em.find(TypeDeService.class, id);
			return tds1;
	}

	@Override
	public void update(TypeDeService tds) {
		TypeDeService tds1=(TypeDeService) em.find(TypeDeService.class, tds.getId());
	    tds1.setLabel(tds.getLabel());
		em.persist(tds1);
		
	}

	@Override
	public void delete(TypeDeService tds) {
		em.remove(tds);
		
	}

}
