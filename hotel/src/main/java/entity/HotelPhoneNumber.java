package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class HotelPhoneNumber {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "phonenumber_id")
    private int phoneNumberId;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Basic
    @Column(name = "number")
    private String number;

    public int getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(int phonenumberId) {
        this.phoneNumberId = phonenumberId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
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
        HotelPhoneNumber that = (HotelPhoneNumber) o;
        return phoneNumberId == that.phoneNumberId && hotel == that.hotel && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumberId, hotel, number);
    }
}
