package services;

import dao.EmployeeDao;
import entity.Employee;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(EntityManagerFactory emf) {
        this.employeeDao = new EmployeeDao(emf);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.readAll();
    }
}
