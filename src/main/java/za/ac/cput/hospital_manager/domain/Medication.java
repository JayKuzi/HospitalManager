package za.ac.cput.hospital_manager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Medication implements Serializable {
    @Id
    private String medicationId;
    private String medicationName, medicationPrescription, password;

   protected Medication (){

    }

    private Medication (Builder builder){
        this.medicationId = builder.medicationId;
        this.medicationName = builder.medicationName;
        this.medicationPrescription = builder.medicationPrescription;
        this.password = builder.password;
    }

    public String getMedicationId() {
        return medicationId;
    }



    public String getMedicationName() {
        return medicationName;
    }

    public String getMedicationPrescription() {
        return medicationPrescription;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationId='" + medicationId + '\'' +
                ", MedicationName='" + medicationName + '\'' +
                ", MedicationPrescription='" + medicationPrescription + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication medication = (Medication) o;
        return medicationId.equals(medication.medicationId)  && medicationName.equals(medication.medicationName) && medicationPrescription.equals(medication.medicationPrescription) && password.equals(medication.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationId, medicationName, medicationPrescription, password);
    }

    public static class Builder {
        private String medicationId, medicationName, medicationPrescription, password;


        public Builder medicationId(String medicationId){
            this.medicationId = medicationId;
            return this;

        }

        public Builder medicationName(String medicationName){
            this.medicationName = medicationName;
            return this;

        }

        public Builder medicationPrescription(String medicationPrescription){
            this.medicationPrescription = medicationPrescription;
            return this;


        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Medication build(){
            return new Medication(this);
        }
    }
}
