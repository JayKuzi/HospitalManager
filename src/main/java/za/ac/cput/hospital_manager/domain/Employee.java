/* Doctor.java
Entity for the Doctor
Author: Jody Kearns (209023651)
Date: 26 March 2022 */
package za.ac.cput.hospital_manager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Employee implements Serializable {

    @Id
    private String employeeId;
    private String name, surname, username, password;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Shift shift;

    protected Employee (){

    }

    private Employee (Builder builder){
        this.employeeId = builder.employeeId;
        this.role = builder.role;
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

    public Shift getShift()
    {
        return shift;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", roleId=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getEmployeeId().equals(employee.getEmployeeId()) && getName().equals(employee.getName()) && getSurname().equals(employee.getSurname()) && getUsername().equals(employee.getUsername()) && getPassword().equals(employee.getPassword()) && getRole().equals(employee.getRole()) && Objects.equals(getShift(), employee.getShift());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getEmployeeId(), getName(), getSurname(), getUsername(), getPassword(), getRole(), getShift());
    }

    public static class Builder {
        private String employeeId, name, surname, username, password;
        private Role role;

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder role(Role role){
            this.role = role;
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
