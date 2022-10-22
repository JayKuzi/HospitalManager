package za.ac.cput.hospital_manager.service.addressService;

import za.ac.cput.hospital_manager.domain.Address;
import za.ac.cput.hospital_manager.service.IService;

public interface IAddressService extends IService<Address, String> {
    void deleteById(String id);
}
