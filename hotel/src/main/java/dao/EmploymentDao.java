package dao;

import entity.Employment;

import javax.persistence.EntityManagerFactory;

public class EmploymentDao extends AbstractDao<Employment>{
    public EmploymentDao(EntityManagerFactory emf) {
        super(emf, Employment.class);
    }
}
