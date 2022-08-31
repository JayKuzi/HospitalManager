package za.ac.cput.hospital_manager.service.shiftService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospital_manager.domain.Shift;
import za.ac.cput.hospital_manager.repository.IShiftRepository;
import za.ac.cput.hospital_manager.service.shiftService.IShiftService;

import java.util.List;
import java.util.Optional;

@Service
public class ShiftServiceImpl implements IShiftService {

    IShiftRepository shiftRepository;

    @Autowired
    public ShiftServiceImpl(IShiftRepository repository)
    {
        shiftRepository = repository;
    }

    @Override
    public Shift save(Shift shift)
    {
        return shiftRepository.save(shift);
    }

    @Override
    public Optional<Shift> read(Integer id)
    {
        return shiftRepository.findById(id);
    }

    @Override
    public List<Shift> findAll()
    {
        return shiftRepository.findAll();
    }

    @Override
    public void delete(Shift shift)
    {
        shiftRepository.delete(shift);
    }

    @Override
    public void deleteById(int shiftId)
    {
        shiftRepository.deleteById(shiftId);
    }
}
