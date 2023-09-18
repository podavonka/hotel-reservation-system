package dao;

import entity.Breakfast;
import entity.BreakfastPK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BreakfastDao extends AbstractDao<Breakfast>{
    public BreakfastDao(EntityManagerFactory emf) {
        super(emf, Breakfast.class);
    }

    public Breakfast read(BreakfastPK id) {
        EntityManager em = emf.createEntityManager();
        Breakfast breakfast = em.find(type, id);
        em.close();
        return breakfast;
    }
}
