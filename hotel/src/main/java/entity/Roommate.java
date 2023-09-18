package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Roommate {
    @EmbeddedId
    private RoommatePK roommatePK;

    public RoommatePK getRoommatePK() {
        return roommatePK;
    }

    public void setRoommatePK(RoommatePK roommatePK) {
        this.roommatePK = roommatePK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roommate roommate = (Roommate) o;
        return roommatePK == roommate.roommatePK;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roommatePK);
    }
}
