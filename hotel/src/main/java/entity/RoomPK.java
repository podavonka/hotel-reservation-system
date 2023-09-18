package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RoomPK implements Serializable {
    @Column(name = "hotel")
    private int hotel;
    @Column(name = "number")
    private String number;

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomPK roomPK = (RoomPK) o;
        return hotel == roomPK.hotel && Objects.equals(number, roomPK.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel, number);
    }
}
