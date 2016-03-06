package model;
import java.util.List;

import data.Donnee;
public interface DonneesMetierLocal {
public void ajouter(Donnee donnee);
public List <Donnee> getAll();
public Donnee select(Long id);
public void update(Donnee donnee);
public void delete (Donnee donnee);
}
