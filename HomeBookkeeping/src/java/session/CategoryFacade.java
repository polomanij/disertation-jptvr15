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
                    .setParameter("type", "income")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
