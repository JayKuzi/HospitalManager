package za.ac.cput.hospital_manager.service.roleService;

import za.ac.cput.hospital_manager.domain.Role;
import za.ac.cput.hospital_manager.service.IService;

public interface IRoleService extends IService<Role, String> {
    void deleteById(String id);
}
