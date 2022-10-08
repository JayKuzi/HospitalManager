package za.ac.cput.hospital_manager.factory;

import za.ac.cput.hospital_manager.domain.Employee;
import za.ac.cput.hospital_manager.domain.Shift;
import za.ac.cput.hospital_manager.helper.Helper;

import java.time.LocalTime;
import java.util.Set;

public class ShiftFactory {
    public static Shift build(int shiftId, LocalTime shiftStartTime, LocalTime shiftEndTime, String shiftType, Set<Employee> employees)
    {
        Helper.checkStringParam("shiftType", shiftType);
        Helper.checkIfObjectNull("shiftStartTime", shiftStartTime);
        Helper.checkIfObjectNull("shiftEndTime", shiftEndTime);

        return new Shift.Builder().setShiftId(shiftId)
                                  .setShiftStartTime(shiftStartTime)
                                  .setShiftEndTime(shiftEndTime)
                                  .setShiftType(shiftType)
                                  .setShiftEmployees(employees)
                                  .build();

    }
}