package dao;

import entity.Guest;

import javax.persistence.EntityManagerFactory;

public class GuestDao extends AbstractDao<Guest> {
    public GuestDao(EntityManagerFactory emf) {
        super(emf, Guest.class);
    }
}


