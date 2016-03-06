package model;
import java.util.List;

import data.Lit;
public interface LitMetierLocal {
public void ajouter(Lit lit);
public List <Lit> getAll();
public Lit select(Long id);
public void update(Lit lit);
public void delete (Lit lit);
}
