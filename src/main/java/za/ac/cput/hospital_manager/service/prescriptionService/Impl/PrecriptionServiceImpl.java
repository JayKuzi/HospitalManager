package za.ac.cput.hospital_manager.service.prescriptionService.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospital_manager.domain.Prescription;
import za.ac.cput.hospital_manager.repository.IPrecriptionRepository;
import za.ac.cput.hospital_manager.service.prescriptionService.IPrescriptionService;

import java.util.List;
import java.util.Optional;
@Service
public class PrecriptionServiceImpl implements IPrescriptionService {
    private final IPrecriptionRepository repository;


    @Autowired
    public PrecriptionServiceImpl(IPrecriptionRepository repository){
        this.repository = repository;
    }

    @Override
    public Prescription save(Prescription prescription) {return this.repository.save(prescription);}

    @Override
    public Optional<Prescription> read(String id)
    {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Prescription prescription) {
        this.repository.delete(prescription);
    }

    @Override
    public List<Prescription> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(String id) {
        this.repository.deleteById(id);
        Optional<Prescription> prescription = read(id);
        if (prescription.isPresent()) {
            delete(prescription.get());
        }
    }
}
