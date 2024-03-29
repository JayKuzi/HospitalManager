package za.ac.cput.hospital_manager.factory;

import za.ac.cput.hospital_manager.domain.Prescription;
import za.ac.cput.hospital_manager.helper.Helper;

public class PrescriptionFactory {
    public static Prescription build(String prescriptionId,String patientId, String medicationId){
        Helper.checkStringParam("PrescriptionId", prescriptionId);
        Helper.checkStringParam("patientId", patientId);
        Helper.checkStringParam("medicationId", medicationId);

        return new Prescription.Builder().prescriptionId(prescriptionId).patientId(patientId).medicationId(medicationId).build();

    }
}
