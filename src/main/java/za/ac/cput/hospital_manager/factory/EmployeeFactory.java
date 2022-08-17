package za.ac.cput.hospital_manager.factory;

import za.ac.cput.hospital_manager.domain.Employee;
import za.ac.cput.hospital_manager.domain.Role;
import za.ac.cput.hospital_manager.helper.Helper;

public class EmployeeFactory {

    public static Employee build(String employeeId, Role role, String name, String surname, String username, String password){
        Helper.checkStringParam("employeeId", employeeId);
        Helper.checkIfObjectNull("role", role);
        Helper.checkStringParam("name", name);
        Helper.checkStringParam("surname", surname);
        Helper.checkStringParam("username", username);
        Helper.checkStringParam("password", password);

        return new Employee.Builder().employeeId(employeeId).role(role).name(name).surname(surname).username(username).password(password).build();

    }
}
