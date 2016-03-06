package model;
import java.util.List;

import data.Service;
public interface ServiceMetierLocal {
public void ajouter(Service service);
public List <Service> getAll();
public Service select(Long id);
public void update(Service service);
public void delete (Service service);
}
