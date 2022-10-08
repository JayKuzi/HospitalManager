package za.ac.cput.hospital_manager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Shift implements Serializable {

    @Id
    @GeneratedValue /*(strategy = GenerationType.IDENTITY)*/
    private int shiftId;

    private LocalTime shiftStartTime;

    private LocalTime shiftEndTime;

    private String shiftType;

    @ManyToMany
    private Set<Employee> shiftEmployees;


    protected Shift()
    {
        shiftEmployees = new HashSet<>();
    }

    private Shift(Builder builder)
    {
        this.shiftId = builder.shiftId;
        this.shiftStartTime = builder.shiftStartTime;
        this.shiftEndTime = builder.shiftEndTime;
        this.shiftEmployees = builder.shiftEmployees;
        this.shiftType = builder.shiftType;
    }

    public int getShiftId()
    {
        return shiftId;
    }

    public LocalTime getShiftStartTime()
    {
        return shiftStartTime;
    }

    public LocalTime getShiftEndTime()
    {
        return shiftEndTime;
    }

    public String getShiftType() { return shiftType; }

    public Set<Employee> getShiftEmployees()
    {
        return shiftEmployees;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Shift)) return false;
        Shift shift = (Shift) o;
        return getShiftId() == shift.getShiftId() && Objects.equals(getShiftStartTime(), shift.getShiftStartTime()) && Objects.equals(getShiftEndTime(), shift.getShiftEndTime()) && Objects.equals(getShiftType(), shift.getShiftType()) && Objects.equals(getShiftEmployees(), shift.getShiftEmployees());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getShiftId(), getShiftStartTime(), getShiftEndTime(), getShiftType(), getShiftEmployees());
    }

    public static class Builder{
        private int shiftId;
        private LocalTime shiftStartTime;
        private LocalTime shiftEndTime;
        private String shiftType;
        private Set<Employee> shiftEmployees;

        public Builder setShiftId(int shiftId)
        {
            this.shiftId = shiftId;
            return this;
        }

        public Builder setShiftStartTime(LocalTime shiftStartTime)
        {
            this.shiftStartTime = shiftStartTime;
            return this;
        }

        public Builder setShiftEndTime(LocalTime shiftEndTime)
        {
            this.shiftEndTime = shiftEndTime;
            return this;
        }

        public Builder setShiftType(String shiftType)
        {
            this.shiftType = shiftType;
            return this;
        }

        public Builder setShiftEmployees(Set<Employee> employees)
        {
            this.shiftEmployees = employees;
            return this;
        }

        public Builder copy(Shift shift)
        {
            this.shiftId = shift.shiftId;
            this.shiftStartTime = shift.shiftStartTime;
            this.shiftEndTime = shift.shiftEndTime;
            this.shiftEmployees = shift.shiftEmployees;
            this.shiftType = shift.shiftType;
            return this;
        }

        public Shift build()
        {
            return new Shift(this);
        }
    }
}
