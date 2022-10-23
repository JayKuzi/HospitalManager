package za.ac.cput.hospital_manager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Prescription implements Serializable {
    @Id
    private String prescriptionId;
    private String patientId, medicationId;



    protected Prescription(){

    }

    private Prescription (Builder builder){
        this.prescriptionId = builder.prescriptionId;
        this.patientId = builder.patientId;
        this.medicationId = builder.medicationId;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getMedicationId() {
        return medicationId;
    }


    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId='" + prescriptionId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", medicationId='" + medicationId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription prescription= (Prescription) o;
        return medicationId.equals(prescription.prescriptionId)  && patientId.equals(prescription.patientId) && medicationId.equals(prescription.medicationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionId, patientId, medicationId);
    }

    public static class Builder {
        private String prescriptionId, patientId, medicationId;


        public Builder prescriptionId(String prescriptionId){
            this.prescriptionId = prescriptionId;
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


        public Prescription build(){
            return new Prescription(this);
        }
    }
}
