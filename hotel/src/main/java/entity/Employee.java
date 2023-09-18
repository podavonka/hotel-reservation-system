package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee extends Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id")
    private int employeeId;
    @Basic
    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(name = "Employee_Hotel",
            joinColumns=@JoinColumn(name="employee_id"),
            inverseJoinColumns=@JoinColumn(name="hotel_id"))
    private List<Hotel> hotels = new ArrayList<>();

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public void deleteHotels() {
        this.hotels.clear();
    }

    public void addHotel(Hotel hotel) {
        if (!hotels.contains(hotel)) this.hotels.add(hotel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, email);
    }
}
