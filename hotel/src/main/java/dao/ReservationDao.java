package dao;

import entity.Reservation;

import javax.persistence.EntityManagerFactory;

public class ReservationDao extends AbstractDao<Reservation>{
    public ReservationDao(EntityManagerFactory emf) {
        super(emf, Reservation.class);
    }
}
