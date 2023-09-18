package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Room {
    @EmbeddedId
    private RoomPK roomPK;

    @Basic
    @Column(name = "type")
    private String type;

    public RoomPK getRoomPK() {
        return roomPK;
    }

    public void setRoomPK(RoomPK roomPK) {
        this.roomPK = roomPK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomPK, room.roomPK) && Objects.equals(type, room.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomPK, type);
    }
}
