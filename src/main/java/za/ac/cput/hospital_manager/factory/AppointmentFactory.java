package za.ac.cput.hospital_manager.factory;

import za.ac.cput.hospital_manager.domain.Appointment;
import za.ac.cput.hospital_manager.helper.Helper;

public class AppointmentFactory {

    public static Appointment build(String appointmentId, String employeeId,
                                        String patientId, String appointmentType, String appointmentDate,String appointmentTime){
        Helper.checkStringParam("appointmentId", appointmentId);
        Helper.checkStringParam("employeeId", employeeId);
        Helper.checkStringParam("patientId", patientId);
        Helper.checkStringParam("appointmentType", appointmentType);
        Helper.checkStringParam("appointmentDate", appointmentDate);
        Helper.checkStringParam("appointmentTime", appointmentTime);

        return new Appointment.Builder().appointmentId(appointmentId).employeeId(employeeId)
                .patientId(patientId).appointmentType(appointmentType).appointmentDate(appointmentDate).appointmentTime(appointmentTime).build();
    }
    }

