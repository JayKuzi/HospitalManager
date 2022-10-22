package za.ac.cput.hospital_manager.service.patientService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospital_manager.domain.Patient;
import za.ac.cput.hospital_manager.service.patientService.IPatientService;
import za.ac.cput.hospital_manager.repository.IPatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {
    private final IPatientRepository repository;


    @Autowired
    public PatientServiceImpl(IPatientRepository repository){
        this.repository = repository;
    }

    @Override
    public Patient save(Patient patient) {return this.repository.save(patient);}

    @Override
    public Optional<Patient> read(String id)
    {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Patient patient) {
        this.repository.delete(patient);
    }

    @Override
    public List<Patient> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(String id) {
        this.repository.deleteById(id);
        Optional<Patient> patient = read(id);
        if (patient.isPresent()) {
            delete(patient.get());
        }
    }
}
