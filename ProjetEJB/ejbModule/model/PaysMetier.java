package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Pays;

@Stateless
public class PaysMetier implements PaysMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(Pays pays) {
		em.persist(pays);	
	}

	@Override
	public List<Pays> getAll() {
		Query req=em.createQuery("select P from Pays P");
		return req.getResultList();

	}

	@Override
	public Pays select(Long id) {
		Pays d1=em.find(Pays.class, id);
			return d1;
	}

	@Override
	public void update(Pays p) {
		Pays p1=(Pays) em.find(Pays.class, p.getId());
	    p1.setName(p.getName());
	    p1.setRegions(p.getRegions());
		em.persist(p1);
		
	}

	@Override
	public void delete(Pays p) {
		em.remove(p);
		
	}

}
