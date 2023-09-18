package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Hotel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "hotel_id")
    private int hotelId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "housenumber")
    private String houseNumber;
    @Basic
    @Column(name = "postcode")
    private String postcode;
    @ManyToOne
    @JoinColumn(name = "city")
    private City city;
    @Basic
    @Column(name = "email")
    private String email;

    @ManyToMany (mappedBy = "hotels")
    private List<Employee> employees = new ArrayList<>();

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String housenumber) {
        this.houseNumber = housenumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void deleteEmployees() {
        this.employees.clear();
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) this.employees.add(employee);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return hotelId == hotel.hotelId && city == hotel.city && Objects.equals(name, hotel.name) && Objects.equals(street, hotel.street) && Objects.equals(houseNumber, hotel.houseNumber) && Objects.equals(postcode, hotel.postcode) && Objects.equals(email, hotel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, name, street, houseNumber, postcode, city, email);
    }
}
