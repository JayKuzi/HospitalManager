/* Doctor.java
Entity for the Doctor
Author: Jody Kearns (209023651)
Date: 26 March 2022 */
package za.ac.cput.hospital_manager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

@Entity
public class Employee implements Serializable {

    @Id
    private String employeeId;
    private String name, surname, username, password;

    @ManyToOne
    private Role role;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Employee_Shift",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "shift_id") })
    private Set<Shift> shifts;

    protected Employee (){
        shifts = new HashSet<>();
    }

    private Employee (Builder builder){
        this.employeeId = builder.employeeId;
        this.role = builder.role;
        this.shifts = builder.shifts;
        this.name = builder.name;
        this.surname = builder.surname;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Shift> getShift()
    {
        return shifts;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", shift=" + shifts +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmployeeId(), employee.getEmployeeId()) && Objects.equals(getName(), employee.getName()) && Objects.equals(getSurname(), employee.getSurname()) && Objects.equals(getUsername(), employee.getUsername()) && Objects.equals(getPassword(), employee.getPassword()) && Objects.equals(getRole(), employee.getRole()) && Objects.equals(shifts, employee.shifts);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getEmployeeId(), getName(), getSurname(), getUsername(), getPassword(), getRole(), shifts);
    }

    public static class Builder {
        private String employeeId, name, surname, username, password;
        private Role role;
        private Set<Shift> shifts;

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder role(Role role){
            this.role = role;
            return this;
        }

        public Builder shift(Set<Shift> shifts)
        {
            this.shifts = shifts;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
