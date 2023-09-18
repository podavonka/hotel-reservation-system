package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public abstract class AbstractDao<T> {

    protected final Class<T> type;
    protected EntityManagerFactory emf;

    public AbstractDao(EntityManagerFactory emf, Class<T> type) {
        this.emf = emf;
        this.type = type;
    }

    public void create(T o) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
    }

    public T read(Integer id) {
        EntityManager em = emf.createEntityManager();
        T o = em.find(type, id);
        em.close();
        return o;
    }

    public void update(T o) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        T o = em.find(type, id);

        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
        em.close();
    }

    public List<T> readAll() {
        EntityManager em = emf.createEntityManager();
        List<T> objects = em.createNativeQuery("SELECT * FROM " + type.getSimpleName(), type).getResultList();
        em.close();
        return objects;
    }
}
