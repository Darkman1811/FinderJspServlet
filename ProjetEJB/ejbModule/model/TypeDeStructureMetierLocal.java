package model;
import java.util.List;

import data.TypeDeStructure;
public interface TypeDeStructureMetierLocal {
public void ajouter(TypeDeStructure typeDeStructure);
public List <TypeDeStructure> getAll();
public TypeDeStructure select(Long id);
public void update(TypeDeStructure typeDeStructure);
public void delete (TypeDeStructure typeDeStructure);
}
