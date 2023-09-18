package dao;

import entity.Hotel;

import javax.persistence.EntityManagerFactory;

public class HotelDao extends AbstractDao<Hotel>{
    public HotelDao(EntityManagerFactory emf) {
        super(emf, Hotel.class);
    }
}
