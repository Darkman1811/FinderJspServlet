package model;
import java.util.List;

import data.Region;
public interface RegionMetierLocal {
public void ajouter(Region region);
public List <Region> getAll();
public Region select(Long id);
public void update(Region region);
public void delete (Region region);
}
