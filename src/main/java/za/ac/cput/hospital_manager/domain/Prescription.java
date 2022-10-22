package za.ac.cput.hospital_manager.domain;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

public class Prescription implements Serializable {
    @Id
    private String prescriptionId;
    private String patientId, medicationId, password;

    @ManyToOne
    private Role role;

    protected Prescription(){

    }

    private Prescription (Builder builder){
        this.prescriptionId = builder.prescriptionId;
        this.role = builder.role;
        this.patientId = builder.patientId;
        this.medicationId = builder.medicationId;
        this.password = builder.password;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public Role getRole() {
        return role;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getMedicationId() {
        return medicationId;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId='" + prescriptionId + '\'' +
                ", roleId=" + role +
                ", patientId='" + patientId + '\'' +
                ", medicationId='" + medicationId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription prescription= (Prescription) o;
        return medicationId.equals(prescription.prescriptionId) && role.equals(prescription.role) && patientId.equals(prescription.patientId) && medicationId.equals(prescription.medicationId) && password.equals(prescription.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionId, role, patientId, medicationId, password);
    }

    public static class Builder {
        private String prescriptionId, patientId, surname, medicationId, password;
        private Role role;

        public Builder prescriptionId(String prescriptionId){
            this.prescriptionId = prescriptionId;
            return this;
        }

        public Builder role(Role role){
            this.role = role;
            return this;
        }

        public Builder patientId(String patientId){
            this.patientId = patientId;
            return this;
        }

        public Builder medicationId(String medicationId){
            this.medicationId = medicationId;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Prescription build(){
            return new Prescription(this);
        }
    }
}
