package model;
import java.util.List;

import data.TypeDeService;
public interface TypeDeServiceMetierLocal {
public void ajouter(TypeDeService typeDeService);
public List <TypeDeService> getAll();
public TypeDeService select(Long id);
public void update(TypeDeService typeDeService);
public void delete (TypeDeService typeDeService);
}
