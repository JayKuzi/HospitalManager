package za.ac.cput.hospital_manager.service.shiftService;

import za.ac.cput.hospital_manager.domain.Shift;
import za.ac.cput.hospital_manager.service.IService;

public interface IShiftService extends IService<Shift, Integer> {
    void deleteById(int shiftId);
}
