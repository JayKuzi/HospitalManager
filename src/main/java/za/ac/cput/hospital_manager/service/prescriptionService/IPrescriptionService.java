package za.ac.cput.hospital_manager.service.prescriptionService;

import za.ac.cput.hospital_manager.domain.Prescription;
import za.ac.cput.hospital_manager.service.IService;

public interface IPrescriptionService extends IService <Prescription, String> {
    void deleteById(String id);
}
