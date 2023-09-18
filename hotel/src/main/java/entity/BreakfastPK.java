package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class BreakfastPK implements Serializable {

    @Column(name = "hotel")
    private int hotel;
    @Column(name = "date")
    private LocalDate date;

    public BreakfastPK(int hotel, LocalDate date) {
        this.hotel = hotel;
        this.date = date;
    }

    public BreakfastPK() {
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreakfastPK that = (BreakfastPK) o;
        return hotel == that.hotel && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel, date);
    }
}
