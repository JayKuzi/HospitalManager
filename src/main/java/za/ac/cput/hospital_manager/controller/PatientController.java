package za.ac.cput.hospital_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.hospital_manager.domain.Patient;
import za.ac.cput.hospital_manager.factory.PatientFactory;
import za.ac.cput.hospital_manager.service.patientService.IPatientService;

import java.util.List;

@RestController
@RequestMapping("hospital-manager/patient/")
@Slf4j
public class PatientController {

    private final IPatientService patientService;

    @Autowired
    public PatientController(IPatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Patient> save(@RequestBody Patient patient){
        log.info("Save request: {}", patient);
        Patient validatedPatient;
        try {
            validatedPatient = PatientFactory.createPatient(patient.getPatientId(),
                    patient.getFirstName(), patient.getLastName(), patient.getGender(),
                    patient.getContactNumber());
        }catch(IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Patient save = patientService.save(validatedPatient);
        return ResponseEntity.ok(save);
    }
    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Patient> read (@PathVariable String id){
        log.info("Read request: {}", id);
        Patient patient = this.patientService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(patient);
    }
    @GetMapping("read-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Patient>> readAll(){
        List<Patient> patientList = this.patientService.findAll();
        return ResponseEntity.ok(patientList);
    }
}
