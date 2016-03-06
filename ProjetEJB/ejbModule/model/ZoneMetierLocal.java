package model;
import java.util.List;

import data.Zone;
public interface ZoneMetierLocal {
public void ajouter(Zone zone);
public List <Zone> getAll();
public Zone select(Long id);
public void update(Zone zone);
public void delete (Zone zone);
}
