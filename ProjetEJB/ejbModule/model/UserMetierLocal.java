/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import data.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author darkman
 */
@Local
public interface UserMetierLocal {
  public void ajouter(User  user);
   public List<User> getAll();
   public User select(Long id);
      public void update(User user);
      public void delete(User user);
       public User connecter(String login,String pass);
}
