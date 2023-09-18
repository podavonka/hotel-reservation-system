package services;

import dao.HotelDao;
import entity.Hotel;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class HotelService {
    private HotelDao hotelDao;

    public HotelService (EntityManagerFactory emf) {
        this.hotelDao = new HotelDao(emf);
    }

    public Hotel getHotelById(Integer id) {
        return hotelDao.read(id);
    }

    public void updateHotel(Hotel hotel) {
        hotelDao.update(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelDao.readAll();
    }
}
