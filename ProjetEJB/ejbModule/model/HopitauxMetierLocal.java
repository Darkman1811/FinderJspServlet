package model;
import java.util.List;

import data.Hopitaux;

public interface HopitauxMetierLocal {
public void ajouter(Hopitaux hopitaux);
public List <Hopitaux> getAll();
public Hopitaux select(Long id);
public void update(Hopitaux hopitaux);
public void delete (Hopitaux hopitaux);
}
