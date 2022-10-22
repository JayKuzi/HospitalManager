package za.ac.cput.hospital_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.hospital_manager.domain.Address;
import za.ac.cput.hospital_manager.factory.AddressFactory;
import za.ac.cput.hospital_manager.service.addressService.IAddressService;

import java.util.List;

@RestController
@RequestMapping("hospital-manager/address/")
@Slf4j
public class AddressController {

    private final IAddressService addressService;

    @Autowired
    public AddressController(IAddressService addressService){
        this.addressService = addressService;
    }


    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Address> save(@RequestBody Address address){
        log.info("Save request: {}", address);
        Address validatedAddress;
        try{
            validatedAddress = AddressFactory.createAddress(address.getAddressId(),
                    address.getPatientId(), address.getHouseNumber(),
                    address.getStreetName(), address.getSuburb(),
                    address.getCity(), address.getPostalCode(), address.getProvince());
        }catch (IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Address save = addressService.save(validatedAddress);
        return ResponseEntity.ok(save);
    }
    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.addressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Address> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Address address = this.addressService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(address);
    }
    @GetMapping("read-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Address>> readAll(){
        List<Address> addressList = this.addressService.findAll();
        return ResponseEntity.ok(addressList);
    }
}
