package model;
import java.util.List;

import data.TypeDeLit;
public interface TypeDeLitMetierLocal {
public void ajouter(TypeDeLit typeDeLit);
public List <TypeDeLit> getAll();
public TypeDeLit select(Long id);
public void update(TypeDeLit typeDeLit);
public void delete (TypeDeLit typeDeLit);
}
