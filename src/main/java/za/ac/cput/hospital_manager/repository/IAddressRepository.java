package za.ac.cput.hospital_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.hospital_manager.domain.Address;
import za.ac.cput.hospital_manager.domain.Patient;

import java.util.Optional;

@Repository
public interface IAddressRepository extends JpaRepository<Address, String> {
    //void deleteById(String id);

}
