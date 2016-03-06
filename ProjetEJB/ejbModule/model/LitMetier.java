package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Lit;

@Stateless
public class LitMetier implements LitMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(Lit lit) {
		em.persist(lit);	
	}

	@Override
	public List<Lit> getAll() {
		Query req=em.createQuery("select L from Lit L");
		return req.getResultList();

	}

	@Override
	public Lit select(Long id) {
		Lit d1=em.find(Lit.class, id);
			return d1;
	}

	@Override
	public void update(Lit l) {
		Lit l1=(Lit) em.find(Lit.class, l.getId());
	    l1.setEtat(l.getEtat());
	    l1.setLabel(l.getLabel());
	    l1.setNumeroImmobilisation(l.getNumeroImmobilisation());
		em.persist(l1);
		
	}

	@Override
	public void delete(Lit l) {
		em.remove(l);
		
	}

}
