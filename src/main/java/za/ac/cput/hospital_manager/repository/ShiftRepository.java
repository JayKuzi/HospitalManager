package za.ac.cput.hospital_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.hospital_manager.domain.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {
}
