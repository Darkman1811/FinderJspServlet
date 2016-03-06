package model;
import java.util.List;

import data.Pays;
public interface PaysMetierLocal {
public void ajouter(Pays pays);
public List <Pays> getAll();
public Pays select(Long id);
public void update(Pays pays);
public void delete (Pays pays);
}
