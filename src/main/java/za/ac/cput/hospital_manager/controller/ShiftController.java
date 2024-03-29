package za.ac.cput.hospital_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.hospital_manager.domain.Shift;
import za.ac.cput.hospital_manager.factory.ShiftFactory;
import za.ac.cput.hospital_manager.service.shiftService.IShiftService;

import java.util.List;

/***
 * ShiftController.java
 * @author Mbuso Kotobe (218040385)
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("hospital-manager/shift/")
@Slf4j
public class ShiftController {

    private IShiftService shiftService;

    @Autowired
    public ShiftController(IShiftService service)
    {
        shiftService = service;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("save")
    public ResponseEntity<Shift> save(@RequestBody Shift shift)
    {
        Shift shiftRecord = null;
        try{
            shiftRecord = shiftService.save(ShiftFactory.build(
                    shift.getShiftId(),
                    shift.getShiftStartTime(),
                    shift.getShiftEndTime(),
                    shift.getShiftType(),
                    shift.getShiftEmployees()
            ));
        }
        catch(IllegalArgumentException exception)
        {
            log.info("Shift Save: {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(shiftRecord);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("read/{shiftId}")
    public ResponseEntity<Shift> read(@PathVariable int shiftId)
    {
        Shift shiftRecord = shiftService.read(shiftId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(shiftRecord);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("find-all")
    public ResponseEntity<List<Shift>> findAll()
    {
        return ResponseEntity.ok(shiftService.findAll());
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("delete/{shiftId}")
    public ResponseEntity<Void> deleteById(@PathVariable int shiftId)
    {
        shiftService.deleteById(shiftId);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody Shift shift)
    {
        shiftService.deleteById(shift.getShiftId());
        return ResponseEntity.noContent().build();
    }
}
