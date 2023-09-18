package dao;

import entity.Meal;

import javax.persistence.EntityManagerFactory;

public class MealDao extends AbstractDao<Meal>{
    public MealDao(EntityManagerFactory emf) {
        super(emf, Meal.class);
    }
}
