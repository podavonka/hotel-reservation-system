package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Employment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employment_id")
    private int employmentId;
    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "hotel")
    private Hotel hotel;
    @Basic
    @Column(name = "fromdate")
    private Date fromdate;
    @Basic
    @Column(name = "todate")
    private Date todate;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "salary")
    private BigDecimal salary;

    public int getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(int employmentId) {
        this.employmentId = employmentId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employment that = (Employment) o;
        return employmentId == that.employmentId && employee == that.employee && hotel == that.hotel && Objects.equals(fromdate, that.fromdate) && Objects.equals(todate, that.todate) && Objects.equals(position, that.position) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employmentId, employee, hotel, fromdate, todate, position, salary);
    }
}
