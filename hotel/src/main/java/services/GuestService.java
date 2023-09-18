package services;

import dao.GuestDao;
import entity.Guest;

import javax.persistence.EntityManagerFactory;

public class GuestService {
    private GuestDao guestDao;

    public GuestService(EntityManagerFactory emf) {
        this.guestDao = new GuestDao(emf);
    }

    public Guest getGuest(Integer id) {
        return guestDao.read(id);
    }
}
