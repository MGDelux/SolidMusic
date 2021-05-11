package facade;

import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import secuirty.errorhandling.AuthenticationException;
import security.*;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }
    
    public User getUser(String username) throws AuthenticationException {
        //ONLY USE IF PERSON HAS BEEN VERIFIRED
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
        } finally {
            em.close();
        }
        return user;
    }

    
 
    public void createUser(User user) {
      EntityManager em = emf.createEntityManager();
      User createUser = new User(user.getUserName(),user.getUserPass());
      em.getTransaction().begin();
      em.persist(createUser);
      em.getTransaction().commit();
      }
    
    


}

