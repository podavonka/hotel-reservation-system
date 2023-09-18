package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reservation_id")
    private int reservationId;
    @ManyToOne
    @JoinColumn(name = "hotel")
    private Hotel hotel;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="hotel", referencedColumnName = "hotel", updatable = false, insertable = false),
            @JoinColumn(name="room", referencedColumnName = "number", updatable = false, insertable = false)
    })
    private Room room;
    @ManyToOne
    @JoinColumn(name = "guest")
    private Guest guest;
    @Basic
    @Column(name = "cost")
    private BigDecimal cost;
    @Basic
    @Column(name = "arrivaldate")
    private Date arrivaldate;
    @Basic
    @Column(name = "arrivaltime")
    private Time arrivaltime;
    @Basic
    @Column(name = "departuredate")
    private Date departuredate;
    @Basic
    @Column(name = "departuretime")
    private Time departuretime;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(Date arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public Time getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(Time arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Date departuredate) {
        this.departuredate = departuredate;
    }

    public Time getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Time departuretime) {
        this.departuretime = departuretime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return reservationId == that.reservationId && hotel == that.hotel && guest == that.guest && Objects.equals(room, that.room) && Objects.equals(cost, that.cost) && Objects.equals(arrivaldate, that.arrivaldate) && Objects.equals(arrivaltime, that.arrivaltime) && Objects.equals(departuredate, that.departuredate) && Objects.equals(departuretime, that.departuretime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, hotel, room, guest, cost, arrivaldate, arrivaltime, departuredate, departuretime);
    }
}
