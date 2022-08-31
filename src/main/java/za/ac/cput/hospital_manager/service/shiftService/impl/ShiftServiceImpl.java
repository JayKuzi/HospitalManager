package za.ac.cput.hospital_manager.service.shiftService.impl;

import za.ac.cput.hospital_manager.domain.Shift;
import za.ac.cput.hospital_manager.service.shiftService.IShiftService;

import java.util.List;
import java.util.Optional;

public class ShiftServiceImpl implements IShiftService {
    @Override
    public Shift save(Shift shift)
    {
        return null;
    }

    @Override
    public Optional<Shift> read(Integer id)
    {
        return Optional.empty();
    }

    @Override
    public List<Shift> findAll()
    {
        return null;
    }

    @Override
    public void deleteById(int shiftId)
    {

    }

    @Override
    public void delete(Shift shift)
    {

    }
}
