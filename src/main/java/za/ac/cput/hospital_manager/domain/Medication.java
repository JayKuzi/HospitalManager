package za.ac.cput.hospital_manager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Medication implements Serializable {
    @Id
    private String medicationId;
    private String medicationName, medicationDescription;

   protected Medication (){

    }

    private Medication (Builder builder){
        this.medicationId = builder.medicationId;
        this.medicationName = builder.medicationName;
        this.medicationDescription = builder.medicationDescription;
    }

    public String getMedicationId() {
        return medicationId;
    }



    public String getMedicationName() {
        return medicationName;
    }

    public String getMedicationDescription() {
        return medicationDescription;
    }


    @Override
    public String toString() {
        return "Medication{" +
                "medicationId='" + medicationId + '\'' +
                ", medicationName='" + medicationName + '\'' +
                ", medicationDescription='" + medicationDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication medication = (Medication) o;
        return medicationId.equals(medication.medicationId)  && medicationName.equals(medication.medicationName) && medicationDescription.equals(medication.medicationDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationId, medicationName, medicationDescription);
    }

    public static class Builder {
        private String medicationId, medicationName, medicationDescription;


        public Builder medicationId(String medicationId){
            this.medicationId = medicationId;
            return this;

        }

        public Builder medicationName(String medicationName){
            this.medicationName = medicationName;
            return this;

        }

        public Builder medicationDescription(String medicationDescription){
            this.medicationDescription = medicationDescription;
            return this;


        }


        public Medication build(){
            return new Medication(this);
        }
    }
}
