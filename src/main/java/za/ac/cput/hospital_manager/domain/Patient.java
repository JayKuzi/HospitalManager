package za.ac.cput.hospital_manager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Patient implements Serializable {
    @Id
    private String patientId;

    private String firstName, lastName, gender, contactNumber;

    protected Patient(){

    }
    private Patient(Builder builder){
        this.patientId = builder.patientId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.contactNumber = builder.contactNumber;

    }
    public String getPatientId() {
        return patientId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getGender() {
        return gender;
    }
    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId) &&
                firstName.equals(patient.firstName) &&
                lastName.equals(patient.lastName) &&
                gender.equals(patient.gender) &&
                contactNumber.equals(patient.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, firstName, lastName, gender, contactNumber);
    }

    public static class Builder{
        private String patientId;
        private String firstName, lastName, gender, contactNumber;

        public Builder patientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Patient build(){
            return new Patient(this);
        }

    }
}
