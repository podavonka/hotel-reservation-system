package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RoommatePK implements Serializable {
    @Column(name = "guest1")
    private int guest1;
    @Column(name = "guest2")
    private int guest2;
    @Column(name = "reservation")
    private int reservation;

    public int getGuest1() {
        return guest1;
    }

    public void setGuest1(int guest1) {
        this.guest1 = guest1;
    }

    public int getGuest2() {
        return guest2;
    }

    public void setGuest2(int guest2) {
        this.guest2 = guest2;
    }

    public int getReservation() {
        return reservation;
    }

    public void setReservation(int reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoommatePK that = (RoommatePK) o;
        return guest1 == that.guest1 && guest2 == that.guest2 && reservation == that.reservation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(guest1, guest2, reservation);
    }
}
