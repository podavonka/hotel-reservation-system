package services;

import dao.MealDao;
import entity.Meal;

import javax.persistence.EntityManagerFactory;

public class MealService {
    private MealDao mealDao;

    public MealService(EntityManagerFactory emf) {
        this.mealDao = new MealDao(emf);
    }

    public void addMeal(Meal meal){
        mealDao.create(meal);
    }
}
