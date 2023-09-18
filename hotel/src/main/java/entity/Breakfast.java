package entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Breakfast {
    @EmbeddedId
    private BreakfastPK breakfastPK;
    @Basic
    @Column(name = "menu")
    private String menu;
    @Basic
    @Column(name = "portions")
    private int portions;
    @Basic
    @Column(name = "reserved")
    private int reserved;
    @Basic
    @Column(name = "earliesttime")
    private Time earliesttime;
    @Basic
    @Column(name = "latesttime")
    private Time latesttime;


    public BreakfastPK getBreakfastPK() {
        return breakfastPK;
    }

    public void setBreakfastPK(BreakfastPK breakfastPK) {
        this.breakfastPK = breakfastPK;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public Time getEarliesttime() {
        return earliesttime;
    }

    public void setEarliesttime(Time earliesttime) {
        this.earliesttime = earliesttime;
    }

    public Time getLatesttime() {
        return latesttime;
    }

    public void setLatesttime(Time latesttime) {
        this.latesttime = latesttime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Breakfast breakfast = (Breakfast) o;
        return breakfastPK.getHotel() == breakfast.getBreakfastPK().getHotel() && portions == breakfast.portions && reserved == breakfast.reserved && Objects.equals(breakfastPK.getDate(), breakfast.getBreakfastPK().getDate()) && Objects.equals(menu, breakfast.menu) && Objects.equals(earliesttime, breakfast.earliesttime) && Objects.equals(latesttime, breakfast.latesttime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breakfastPK.getHotel(), breakfastPK.getDate(), menu, portions, reserved, earliesttime, latesttime);
    }
}
