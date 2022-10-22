package za.ac.cput.hospital_manager.domain;

/*
 * Zintle Magwaxaza (218109911)
 * Appointment.java
 * Date: 10 August 2022
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

import java.util.Objects;

@Entity
public class Appointment implements Serializable {
    @Id
    private String appointmentId;
    private String employeeId;
    private String patientId;
    private String appointmentType;
    private String appointmentDate;
    private String appointmentTime;

    public Appointment() {
    }

    public Appointment(Builder builder) {
        this.employeeId = builder.employeeId;
        this.patientId = builder.patientId;
        this.appointmentType = builder.appointmentType;
        this.appointmentDate = builder.appointmentDate;
        this.appointmentTime = builder.appointmentTime;
        if (builder.appointmentId != null) {
            this.appointmentId = builder.appointmentId;
        }
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                "employeeId='" + employeeId + '\'' +
                ", patientId=" + patientId +
                ", AppointmentType='" + appointmentType + '\'' +
                ", AppointmentDate='" + appointmentDate + '\'' +
                ", AppointmentTime='" + appointmentTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment appointment = (Appointment) o;
        return appointmentId.equals(appointment.appointmentId) && employeeId.equals(appointment.employeeId) && patientId.equals(appointment.patientId) && appointmentType.equals(appointment.appointmentType) && appointmentDate.equals(appointment.appointmentDate) && appointmentTime.equals(appointment.appointmentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, employeeId, patientId, appointmentType, appointmentDate, appointmentTime);
    }

    public static class Builder {
        private String appointmentId, employeeId, patientId, appointmentType;
        private String appointmentDate;
        private String appointmentTime;

        public Builder appointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder patientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder appointmentType(String appointmentType) {
            this.appointmentType = appointmentType;
            return this;
        }

        public Builder appointmentDate(String appointmentDate) {
            this.appointmentDate = appointmentDate;
            return this;
        }

        public Builder appointmentTime(String appointmentTime) {
            this.appointmentTime = appointmentTime;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }

    }
}
