package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Zone;

@Stateless
public class ZoneMetier implements ZoneMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(Zone zone) {
		em.persist(zone);	
	}

	@Override
	public List<Zone> getAll() {
		Query req=em.createQuery("select Z from Zone Z");
		return req.getResultList();

	}

	@Override
	public Zone select(Long id) {
		Zone z1=em.find(Zone.class, id);
			return z1;
	}

	@Override
	public void update(Zone z) {
		Zone z1=(Zone) em.find(Zone.class, z.getId());
	    z1.setName(z.getName());
		em.persist(z1);
		
	}

	@Override
	public void delete(Zone z) {
		em.remove(z);
		
	}

}
