package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ColleaguePK implements Serializable {
    @Column(name = "employee1")
    private int employee1;

    @Column(name = "employee2")
    private int employee2;

    public int getEmployee1() {
        return employee1;
    }

    public void setEmployee1(int employee1) {
        this.employee1 = employee1;
    }

    public int getEmployee2() {
        return employee2;
    }

    public void setEmployee2(int employee2) {
        this.employee2 = employee2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColleaguePK that = (ColleaguePK) o;
        return employee1 == that.employee1 && employee2 == that.employee2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee1, employee2);
    }
}
