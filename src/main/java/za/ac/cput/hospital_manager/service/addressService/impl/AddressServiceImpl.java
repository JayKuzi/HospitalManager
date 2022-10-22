package za.ac.cput.hospital_manager.service.addressService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospital_manager.domain.Address;
import za.ac.cput.hospital_manager.service.addressService.IAddressService;
import za.ac.cput.hospital_manager.repository.IAddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    private final IAddressRepository repository;


    @Autowired
    public AddressServiceImpl(IAddressRepository repository){
        this.repository = repository;
    }

    @Override
    public Address save(Address address) {return this.repository.save(address);}

    @Override
    public Optional<Address> read(String id)
    {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Address address) {
        this.repository.delete(address);
    }

    @Override
    public List<Address> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(String id) {
        this.repository.deleteById(id);
        Optional<Address> address = read(id);
        if (address.isPresent()) {
            delete(address.get());
        }
    }
}
