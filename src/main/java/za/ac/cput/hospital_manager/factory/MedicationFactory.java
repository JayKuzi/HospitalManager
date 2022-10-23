package za.ac.cput.hospital_manager.factory;
import za.ac.cput.hospital_manager.domain.Medication;
import za.ac.cput.hospital_manager.helper.Helper;

public class MedicationFactory {
    public static Medication build(String medicationId, String medicationName, String medicationDescription){
        Helper.checkStringParam("medicationId", medicationId);
        Helper.checkStringParam("medicationName", medicationName);
        Helper.checkStringParam("medicationDescription", medicationDescription);

      return new Medication.Builder().medicationId(medicationId).medicationName(medicationName).medicationDescription(medicationDescription).build();
    }
}
