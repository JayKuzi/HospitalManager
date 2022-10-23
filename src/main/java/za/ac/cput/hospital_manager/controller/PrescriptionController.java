package za.ac.cput.hospital_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.hospital_manager.domain.Prescription;
import za.ac.cput.hospital_manager.factory.PrescriptionFactory;
import za.ac.cput.hospital_manager.service.prescriptionService.IPrescriptionService;

import java.util.List;
@RestController
@RequestMapping("hospital-manager/prescription/")
@Slf4j
public class PrescriptionController {
    private final IPrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(IPrescriptionService prescriptionService){
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Prescription> save(@RequestBody Prescription prescription){
        log.info("Save request: {}", prescription);
        Prescription validatedPrescription;
        try{

            validatedPrescription = PrescriptionFactory.build(prescription.getPrescriptionId(),prescription.getPatientId(),
                    prescription.getMedicationId());
        }catch(IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
       Prescription save = prescriptionService.save(validatedPrescription);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.prescriptionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Prescription> read (@PathVariable String id){
        log.info("Read request: {}", id);
        Prescription prescription = this.prescriptionService.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(prescription);
    }

    @GetMapping("read-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Prescription>> readAll(){
        List<Prescription> prescriptionList = this.prescriptionService.findAll();
        return ResponseEntity.ok(prescriptionList);
    }
}
