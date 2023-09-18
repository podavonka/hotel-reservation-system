package services;

import dao.EmploymentDao;
import entity.Employment;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EmploymentService {
    private EmploymentDao employmentDao;

    public EmploymentService(EntityManagerFactory emf) {
        this.employmentDao = new EmploymentDao(emf);
    }

    public List<Employment> getAllEmployments() {
        return employmentDao.readAll();
    }
}
