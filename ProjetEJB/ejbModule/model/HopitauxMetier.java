package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Agent;;

@Stateless
public class HopitauxMetier implements AgentMetierLocal{
@PersistenceContext(unitName="test-ejbPU")
private EntityManager em;
	@Override
	public void ajouter(Agent agent) {
		em.persist(agent);	
	}

	@Override
	public List<Agent> getAll() {
		Query req=em.createQuery("select A from Agent a");
		return req.getResultList();

	}

	@Override
	public Agent select(Long id) {
		Agent a1=em.find(Agent.class, id);
			return a1;
	}

	@Override
	public void update(Agent a) {
		Agent a1=(Agent) em.find(Agent.class, a.getId());
	    a1.setAdresse(a.getAdresse());
	    a1.setEmail(a.getEmail());
	    a1.setNom(a.getNom());
	    a1.setPhone(a.getPhone());
	    a1.setPrenom(a.getPrenom());
		em.persist(a1);
		
	}

	@Override
	public void delete(Agent a) {
		em.remove(a);
		
	}

}
