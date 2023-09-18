package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "city_id")
    private int cityId;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "name")
    private String name;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId && Objects.equals(country, city.country) && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, country, name);
    }
}
