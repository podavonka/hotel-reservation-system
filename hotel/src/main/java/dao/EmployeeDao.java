package dao;

import entity.Employee;

import javax.persistence.EntityManagerFactory;

public class EmployeeDao extends AbstractDao<Employee>{
    public EmployeeDao(EntityManagerFactory emf) {
        super(emf, Employee.class);
    }
}
