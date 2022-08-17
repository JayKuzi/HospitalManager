package za.ac.cput.hospital_manager.factory;

import za.ac.cput.hospital_manager.domain.Role;
import za.ac.cput.hospital_manager.helper.Helper;

public class RoleFactory {
    public static Role build(String roleId, String roleName, String roleDescription){

        Helper.checkStringParam("roleId", roleId);
        Helper.checkStringParam("roleName", roleName);
        Helper.checkStringParam("roleDescription", roleDescription);

        return new Role.Builder().roleId(roleId).roleName(roleName).roleDescription(roleDescription).build();
    }
}
