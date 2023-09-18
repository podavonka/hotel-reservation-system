package entity;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Meal {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "meal_id")
    private int mealId;

    @ManyToOne
    @JoinColumn(name = "guest", nullable = false)
    private Guest guest;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="hotel", referencedColumnName = "hotel", nullable = false),
            @JoinColumn(name="date", referencedColumnName = "date", nullable = false)
    })
    private Breakfast breakfast;

    @ManyToOne
    @JoinColumn(name = "reservation", nullable = false)
    private Reservation reservation;

    @Basic
    @Column(name = "reservedtime")
    private Time reservedtime;

    public Meal(Guest guest, Breakfast breakfast, Reservation reservation, LocalTime reservedtime) {
        this.guest = guest;
        this.reservation = reservation;
        this.breakfast = breakfast;
        this.reservedtime = Time.valueOf(reservedtime);
    }

    public Meal() {
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Breakfast getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Breakfast breakfast) {
        this.breakfast = breakfast;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Time getReservedtime() {
        return reservedtime;
    }

    public void setReservedtime(Time reservedtime) {
        this.reservedtime = reservedtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return mealId == meal.mealId && guest == meal.guest && breakfast == meal.breakfast && reservation == meal.reservation && Objects.equals(reservedtime, meal.reservedtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, guest, breakfast, reservation, reservedtime);
    }
}
