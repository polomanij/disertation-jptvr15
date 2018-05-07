package session;

import entity.Category;
import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryFacade extends AbstractFacade<Category> {

    @PersistenceContext(unitName = "HomeBookkeepingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }

    public List<Category> findByUserWithType(User user, String type){
        try {
            return em.createQuery("SELECT c FROM Category c WHERE c.user=:user AND c.type=:type")
                    .setParameter("user", user)
                    .setParameter("type", type)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Category> findByUserWithType(User user, String type, boolean active){
        try {
            return em.createQuery("SELECT c FROM Category c WHERE c.user=:user AND c.type=:type AND c.active=:active")
                    .setParameter("user", user)
                    .setParameter("type", type)
                    .setParameter("active", active)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Category find(String name, String type, User user) {
        try {
            return (Category) em.createQuery("SELECT c FROM Category c WHERE c.name=:name AND c.type=:type AND c.user=:user")
                    .setParameter("name", name)
                    .setParameter("type", type)
                    .setParameter("user", user)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void rename(String name, String newName, String type, User user) {
        try {
            em.createQuery("UPDATE Category c SET c.name=:newName WHERE c.name=:name AND c.type=:type AND c.user=:user")
                    .setParameter("newName", newName)
                    .setParameter("name", name)
                    .setParameter("type", type)
                    .setParameter("user", user)
                    .executeUpdate();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
    
    public void changeActivate(String name, String type, User user) {
        Category category = find(name, type, user);
        
        try {
            em.createQuery("UPDATE Category c SET c.active=:active WHERE c.name=:name AND c.type=:type AND c.user=:user")
                    .setParameter("name", name)
                    .setParameter("type", type)
                    .setParameter("user", user)
                    .setParameter("active", !category.isActive())
                    .executeUpdate();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
