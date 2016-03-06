package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Donnee;

@Stateless
public class DonneesMetier implements DonneesMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(Donnee donnee) {
		em.persist(donnee);	
	}

	@Override
	public List<Donnee> getAll() {
		Query req=em.createQuery("select D from Donnee D");
		return req.getResultList();

	}

	@Override
	public Donnee select(Long id) {
		Donnee d1=em.find(Donnee.class, id);
			return d1;
	}

	@Override
	public void update(Donnee d) {
		Donnee d1=(Donnee) em.find(Donnee.class, d.getId());
	    d1.setName("new name");
		em.persist(d1);
		
	}

	@Override
	public void delete(Donnee d) {
		em.remove(d);
		
	}

}
