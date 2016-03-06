/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import data.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author darkman
 */
@Stateless
public class UserMetier implements UserMetierLocal {

    
     @PersistenceContext(unitName = "test-ejbPU")
    private EntityManager em;
 
 public void ajouter(User  user) {
         em.persist(user);
    }

    
    public List<User> getAll() {
     Query req=em.createQuery("select U from User U");
        return req.getResultList();
    }

 public User select(Long id)
    {
        User user=em.find(User.class,id );
        return user;
    }
    public void update(User user) {
       User user1=em.find(User.class,user.getId() );
       user1.setId(user.getId());
       user1.setLogin(user.getLogin());
       user1.setNom(user.getNom());
       user1.setPassword(user.getPassword());
       user1.setPhone(user.getPhone());
       user1.setPrenom(user.getPrenom());
       user1.setUserRole(user.getUserRole());
       
       em.merge(user1);         
    }
   
    public void delete(User user) {
      User user1=em.find(User.class,user.getId() );
      em.remove(user1);   
    } 
    
    
    public User connecter(String login,String pass)
    {
         Query req=em.createQuery("select U from User U where U.login='"+login+"' and U.password='"+pass+"'");
         try{
            return (User)req.getSingleResult();
        }
         catch (Exception e)
         {
             return null;
        }
        
    }
}
