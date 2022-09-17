package za.ac.cput.hospital_manager.controller;

/*
author: Ameer Ismail
student nr: 218216033
Controller: Ward controller
Project 3 Ind Assignment
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.hospital_manager.domain.Ward;
import za.ac.cput.hospital_manager.factory.WardFactory;
import za.ac.cput.hospital_manager.service.wardService.IWardService;

import java.util.List;

@RestController
@RequestMapping("hospital-manager/ward/")
@Slf4j
public class WardController
{
    private final IWardService wardService;

    @Autowired
    public WardController(IWardService wardService)
    {
        this.wardService = wardService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("save")
    public ResponseEntity<Ward> save (@RequestBody Ward ward)
    {
        log.info("Save: ", ward);

        Ward ValidateWard;
        try
        {
            ValidateWard = WardFactory.build(ward.getWardId(), ward.getWardName(), ward.getWardDescription(),
                    ward.getWardSize());
        }catch (IllegalArgumentException i)
        {
            log.info("Save: ", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Ward save = wardService.save(ValidateWard);
        return ResponseEntity.ok(save);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("read/{id}")
    public ResponseEntity<Ward> read(@PathVariable int id)
    {
        log.info("Read: ", id);
        Ward ward = this.wardService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(ward);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("find-all")
    public ResponseEntity<List<Ward>> findAll()
    {
        List<Ward> wardLists = this.wardService.findAll();
        return ResponseEntity.ok(wardLists);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable int id)
    {
        log.info("Delete: ", id);
        this.wardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
