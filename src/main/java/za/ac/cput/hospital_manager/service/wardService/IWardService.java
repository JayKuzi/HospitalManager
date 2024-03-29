package za.ac.cput.hospital_manager.service.wardService;


import za.ac.cput.hospital_manager.domain.Ward;
import za.ac.cput.hospital_manager.service.IService;

public interface IWardService extends IService<Ward, String>
{
    void deleteById(String id);
}
