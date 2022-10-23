package za.ac.cput.hospital_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.hospital_manager.domain.Medication;
import za.ac.cput.hospital_manager.factory.MedicationFactory;
import za.ac.cput.hospital_manager.service.medicationService.IMedicationService;

import java.util.List;
@RestController
@RequestMapping("hospital-manager/medication/")
@Slf4j
public class MedicationController {
    private final IMedicationService medicationService;

    @Autowired
    public MedicationController(IMedicationService medicationService){
        this.medicationService = medicationService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Medication> save(@RequestBody Medication medication){
        log.info("Save request: {}", medication);

        Medication validatedMedication;
        try{

            validatedMedication = MedicationFactory.build(medication.getMedicationId(), medication.getMedicationName(),
                    medication.getMedicationDescription());
        }catch(IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Medication save = medicationService.save(validatedMedication);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.medicationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Medication> read (@PathVariable String id){
        log.info("Read request: {}", id);
        Medication medication = this.medicationService.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(medication);
    }

    @GetMapping("read-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Medication>> readAll(){
        List<Medication> medicationList = this.medicationService.findAll();
        return ResponseEntity.ok(medicationList);
    }
}
