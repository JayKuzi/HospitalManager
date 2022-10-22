package za.ac.cput.hospital_manager.factory;

import za.ac.cput.hospital_manager.helper.Helper;
import za.ac.cput.hospital_manager.domain.Patient;

public class PatientFactory {
    public static Patient createPatient(String patientId, String firstName,
                                        String lastName, String gender, String contactNumber){
        Helper.checkStringParam("patientId", patientId);
        Helper.checkStringParam("firstName", firstName);
        Helper.checkStringParam("lastName", lastName);
        Helper.checkStringParam("gender", gender);
        Helper.checkStringParam("contactNumber", contactNumber);

        return new Patient.Builder().patientId(patientId).firstName(firstName)
                .lastName(lastName).gender(gender).contactNumber(contactNumber).build();
    }
}
