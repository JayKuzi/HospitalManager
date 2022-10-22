package za.ac.cput.hospital_manager.service.appointmentService.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospital_manager.domain.Appointment;
import za.ac.cput.hospital_manager.repository.IAppointmentRepository;
import za.ac.cput.hospital_manager.service.appointmentService.IAppointmentService;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final IAppointmentRepository repository;

    @Autowired public AppointmentServiceImpl(IAppointmentRepository repository){
        this.repository = repository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override public void delete(Appointment appointment){this.repository.delete(appointment);}

    @Override
    public Optional<Appointment> read(String id){return this.repository.findById(id);}

    @Override
    public List<Appointment> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id){
        this.repository.deleteById(id);
        Optional<Appointment> appointment = read(id);
        if (appointment.isPresent()){
            delete(appointment.get());
        }

    }
}