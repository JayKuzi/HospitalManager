package za.ac.cput.hospital_manager.factory;
import za.ac.cput.hospital_manager.domain.Medication;
import za.ac.cput.hospital_manager.helper.Helper;

public class MedicationFactory {
    public static Medication build(String medicationId, String medicationName, String medicationPrescription, String password){
        Helper.checkStringParam("medicationId", medicationId);
        Helper.checkStringParam("name", medicationName);
        Helper.checkStringParam("surname", medicationPrescription);
        Helper.checkStringParam("password", password);

      return new Medication.Builder().medicationId(medicationId).medicationName(medicationName).medicationPrescription(medicationPrescription).password(password).build();
    }
}
