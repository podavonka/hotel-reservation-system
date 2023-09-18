package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Colleague {
    @EmbeddedId
    private ColleaguePK colleaguePK;

    public ColleaguePK getColleaguePK() {
        return colleaguePK;
    }

    public void setColleaguePK(ColleaguePK colleaguePK) {
        this.colleaguePK = colleaguePK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colleague colleague = (Colleague) o;
        return colleaguePK == colleague.colleaguePK;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colleaguePK);
    }
}
