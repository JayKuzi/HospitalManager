package za.ac.cput.hospital_manager.service.appointmentService;

import za.ac.cput.hospital_manager.domain.Appointment;
import za.ac.cput.hospital_manager.service.IService;

public interface IAppointmentService extends IService<Appointment, String> {
     void deleteById(String id);


}
