package za.ac.cput.hospital_manager.service.medicationService;

import za.ac.cput.hospital_manager.domain.Medication;
import za.ac.cput.hospital_manager.service.IService;

public interface IMedicationService extends IService <Medication, String> {
    void deleteById(String id);
}
