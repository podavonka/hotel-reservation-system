package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Guest extends Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guest_id")
    private int guestId;
    @Basic
    @Column(name = "phonenumber")
    private String phonenumber;
    @Basic
    @Column(name = "email")
    private String email;

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return guestId == guest.guestId && Objects.equals(phonenumber, guest.phonenumber) && Objects.equals(email, guest.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, phonenumber, email);
    }
}
