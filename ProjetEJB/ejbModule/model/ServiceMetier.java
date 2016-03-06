package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Service;

@Stateless
public class ServiceMetier implements ServiceMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(Service service) {
		em.persist(service);	
	}

	@Override
	public List<Service> getAll() {
		Query req=em.createQuery("select s from Service s");
		return req.getResultList();

	}

	@Override
	public Service select(Long id) {
		Service s1=em.find(Service.class, id);
			return s1;
	}

	@Override
	public void update(Service s) {
		Service s1=(Service) em.find(Service.class, s.getId());
	    s1.setName(s.getName());
	    s1.setNumPhoneInterne(s.getNumPhoneInterne());
		em.persist(s1);
		
	}

	@Override
	public void delete(Service s) {
		em.remove(s);
		
	}

}
