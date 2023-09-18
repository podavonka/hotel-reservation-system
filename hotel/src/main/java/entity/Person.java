package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id")
    protected int personId;
    @Basic
    @Column(name = "firstname")
    protected String firstname;
    @Basic
    @Column(name = "lastname")
    protected String lastname;
    @Basic
    @Column(name = "dateofbirth")
    protected Date dateofbirth;
    @Basic
    @Column(name = "residence")
    protected String residence;
    @Basic
    @Column(name = "gender")
    protected String gender;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId && Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname) && Objects.equals(dateofbirth, person.dateofbirth) && Objects.equals(residence, person.residence) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, firstname, lastname, dateofbirth, residence, gender);
    }
}
