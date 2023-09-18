package services;

import dao.BreakfastDao;
import entity.Breakfast;
import entity.BreakfastPK;
import entity.Hotel;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class BreakfastService {
    private BreakfastDao breakfastDao;

    public BreakfastService(EntityManagerFactory emf) {
        this.breakfastDao = new BreakfastDao(emf);
    }

    public Breakfast getBreakfastByPK(BreakfastPK breakfastPK) {
        return breakfastDao.read(breakfastPK);
    }

    public List<Breakfast> getAllBreakfasts(Hotel hotel) {
        List<Breakfast> breakfasts =  breakfastDao.readAll();
        breakfasts.removeIf(breakfast -> breakfast.getBreakfastPK().getHotel() != hotel.getHotelId());
        return breakfasts;
    }

    public List<Breakfast> getAllBreakfasts() {
        return breakfastDao.readAll();
    }

    public void updateBreakfast(Breakfast breakfast) {
        breakfastDao.update(breakfast);
    }
}
