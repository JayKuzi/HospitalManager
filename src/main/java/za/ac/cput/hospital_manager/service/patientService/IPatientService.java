package za.ac.cput.hospital_manager.service.patientService;

import za.ac.cput.hospital_manager.domain.Patient;
import za.ac.cput.hospital_manager.service.IService;

public interface IPatientService extends IService<Patient, String> {
    void deleteById(String id);
}
