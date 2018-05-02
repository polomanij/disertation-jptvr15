/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Report;
import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author roman
 */
@Stateless
public class ReportFacade extends AbstractFacade<Report> {

    @PersistenceContext(unitName = "HomeBookkeepingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportFacade() {
        super(Report.class);
    }
    
    public List<Report> findIncomesByUser(User user) {
        try {
            return em.createQuery("SELECT r FROM Report r WHERE r.category.user=:user AND r.type=:type")
                    .setParameter("user", user)
                    .setParameter("type", "income")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Report> findExpensesByUser(User user) {
        try {
            return em.createQuery("SELECT r FROM Report r WHERE r.category.user=:user AND r.type=:type")
                    .setParameter("user", user)
                    .setParameter("type", "expense")
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Report findLastAdded(String type, User user) {
        try {
            return (Report) em.createQuery("SELECT r FROM Report r WHERE r.category.user=:user AND r.type=:type ORDER BY r.id DESC")
                    .setMaxResults(1)
                    .setParameter("user", user)
                    .setParameter("type", type)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
