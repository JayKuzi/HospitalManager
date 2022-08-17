package za.ac.cput.hospital_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.hospital_manager.domain.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {

}
