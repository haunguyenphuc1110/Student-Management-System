package edu.tdt.service;

import edu.tdt.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HAU
 */
@Stateless
public class SystemLogin implements SystemLoginRemote {
    @PersistenceContext(unitName = "StudentEJBPU")
    private EntityManager em;
    
    public SystemLogin(){
        
    }
    
    @Override
    public void insertUser(String userName, String userPassword) {
        User user = new User(userName, String.valueOf(userPassword.hashCode()),false);
        em.persist(user);
    }

    @Override
    public String getUserPassword(String username) {
        User user = em.find((User.class), username);
        if(user != null)
            return user.getUserPassword();
        return "-1";
    }

    @Override
    public void changePassword(String username, String newPassword) {
        em.createNativeQuery("UPDATE" + "\"user\""  +"SET user_password = :password WHERE user_name = :id")
                .setParameter("id", username).setParameter("password", String.valueOf(newPassword.hashCode())).executeUpdate();
    }
    
    @Override
    public void update_State(String id,boolean log_in) {
        em.createNativeQuery("UPDATE public.\"user\" "+
                             "SET login=:login " +
                             "WHERE user_name = :id ").setParameter("login", log_in)
                                                      .setParameter("id", id).executeUpdate();
    }

    @Override
    public boolean findState(String userName) {
        User user = em.find(User.class, userName);
        if(user == null)
            return false;
        return user.getLogin();
    }


   
}
