package za.ac.cput.hospital_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.hospital_manager.domain.Appointment;
import za.ac.cput.hospital_manager.factory.AppointmentFactory;
import za.ac.cput.hospital_manager.service.appointmentService.IAppointmentService;

import java.util.List;


@RestController
@RequestMapping("hospital-manager/appointment/")
@Slf4j
public class AppointmentController {

    private final IAppointmentService appointmentService;

    @Autowired
    public AppointmentController(IAppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment){
        log.info("Save request: {}", appointment);

        Appointment ValidateAppointment;

        try{ValidateAppointment = AppointmentFactory.build(appointment.getAppointmentId(), appointment.getEmployeeId(),
                appointment.getPatientId(),appointment.getAppointmentType(),appointment.getAppointmentDate(),appointment.getAppointmentTime();
        }catch (IllegalArgumentException i)
        {
            log.info("Save: ", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Appointment save = appointmentService.save(ValidateAppointment);
        return ResponseEntity.ok(save);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("read/{id}")
    public ResponseEntity<Appointment> read(@PathVariable String id)
    {
        log.info("Read: ", id);
        Appointment appointment = this.appointmentService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(appointment);

    }

    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.appointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")

    public ResponseEntity<Appointment> read (@PathVariable String id){
        log.info("Read request: {}", id);
       Appointment appointment = this.appointmentService.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(appointment);
    }

    @GetMapping("read-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Appointment>> readAll(){
        List<Appointment> appointmentList = this.appointmentService.findAll();
        return ResponseEntity.ok(appointmentList);
    }
}