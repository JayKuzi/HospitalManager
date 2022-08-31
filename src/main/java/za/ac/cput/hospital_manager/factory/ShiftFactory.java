package za.ac.cput.hospital_manager.factory;

import za.ac.cput.hospital_manager.domain.Shift;

import java.time.LocalTime;

public class ShiftFactory {
    public static Shift build(int shiftId, LocalTime shiftStartTime, LocalTime shiftEndTime)
    {
        if (shiftStartTime == null || shiftEndTime == null)
            throw new IllegalArgumentException("Shift Time cannot be null");

        return new Shift.Builder().setShiftId(shiftId)
                                  .setShiftStartTime(shiftStartTime)
                                  .setShiftEndTime(shiftEndTime)
                                  .build();

    }
}
