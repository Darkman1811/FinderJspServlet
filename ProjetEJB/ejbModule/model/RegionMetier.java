package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Region;

@Stateless
public class RegionMetier implements RegionMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(Region region) {
		em.persist(region);	
	}

	@Override
	public List<Region> getAll() {
		Query req=em.createQuery("select R from Region R");
		return req.getResultList();

	}

	@Override
	public Region select(Long id) {
		Region r1=em.find(Region.class, id);
			return r1;
	}

	@Override
	public void update(Region r) {
		Region r1=(Region) em.find(Region.class, r.getId());
	    r1.setName(r.getName());
	    r1.setPays(r.getPays());
		em.persist(r1);
		
	}

	@Override
	public void delete(Region r) {
		em.remove(r);
		
	}

}
