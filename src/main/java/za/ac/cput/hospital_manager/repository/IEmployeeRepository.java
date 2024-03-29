package za.ac.cput.hospital_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.hospital_manager.domain.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {

}
