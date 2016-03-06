package model;
import java.util.List;

import data.Agent;

public interface AgentMetierLocal {
public void ajouter(Agent agent);
public List <Agent> getAll();
public Agent select(Long id);
public void update(Agent agent);
public void delete (Agent agent);
}
