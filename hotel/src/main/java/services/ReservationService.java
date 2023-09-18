package services;

import dao.ReservationDao;
import entity.Reservation;

import javax.persistence.EntityManagerFactory;

public class ReservationService {
    private ReservationDao reservationDao;

    public ReservationService(EntityManagerFactory emf) {
        this.reservationDao = new ReservationDao(emf);
    }

    public Reservation getReservationById(Integer id) {
        return reservationDao.read(id);
    }
}
