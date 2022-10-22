package za.ac.cput.hospital_manager.service.patientService.impl.employeeService;

import za.ac.cput.hospital_manager.domain.Employee;
import za.ac.cput.hospital_manager.service.IService;

public interface IEmployeeService extends IService<Employee, String> {
    void deleteById(String id);
}
