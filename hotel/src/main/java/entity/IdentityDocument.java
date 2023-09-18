package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class IdentityDocument {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "identitydocument_id")
    private int identityDocumentId;
    @Basic
    @Column(name = "issuecountry")
    private String issueCountry;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "number")
    private String number;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "dateofbirth")
    private Date dateOfBirth;
    @Basic
    @Column(name = "residence")
    private String residence;

    public int getIdentityDocumentId() {
        return identityDocumentId;
    }

    public void setIdentityDocumentId(int identitydocumentId) {
        this.identityDocumentId = identitydocumentId;
    }

    public String getIssueCountry() {
        return issueCountry;
    }

    public void setIssueCountry(String issuecountry) {
        this.issueCountry = issuecountry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateofbirth) {
        this.dateOfBirth = dateofbirth;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentityDocument that = (IdentityDocument) o;
        return identityDocumentId == that.identityDocumentId && Objects.equals(issueCountry, that.issueCountry) && Objects.equals(type, that.type) && Objects.equals(number, that.number) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(residence, that.residence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityDocumentId, issueCountry, type, number, firstname, lastname, dateOfBirth, residence);
    }
}
