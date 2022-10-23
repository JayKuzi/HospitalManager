package za.ac.cput.hospital_manager.service.medicationService.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospital_manager.domain.Medication;
import za.ac.cput.hospital_manager.repository.IMedicationRepository;
import za.ac.cput.hospital_manager.service.medicationService.IMedicationService;

import java.util.List;
import java.util.Optional;
@Service
public class MedicationServiceImpl implements IMedicationService  {
    private final IMedicationRepository repository;


    @Autowired
    public MedicationServiceImpl(IMedicationRepository repository){
        this.repository = repository;
    }

    @Override
    public Medication save(Medication medication) {return this.repository.save(medication);}

    @Override
    public Optional<Medication> read(String id)
    {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Medication medication) {
        this.repository.delete(medication);
    }

    @Override
    public List<Medication> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(String id) {
        this.repository.deleteById(id);
        Optional<Medication> address = read(id);
        if (address.isPresent()) {
            delete(address.get());
        }
    }
}
