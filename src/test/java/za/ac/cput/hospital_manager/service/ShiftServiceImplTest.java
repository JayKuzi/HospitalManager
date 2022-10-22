package za.ac.cput.hospital_manager.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.hospital_manager.domain.Employee;
import za.ac.cput.hospital_manager.domain.Role;
import za.ac.cput.hospital_manager.domain.Shift;
import za.ac.cput.hospital_manager.factory.EmployeeFactory;
import za.ac.cput.hospital_manager.factory.RoleFactory;
import za.ac.cput.hospital_manager.factory.ShiftFactory;
import za.ac.cput.hospital_manager.service.shiftService.IShiftService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/***
 * ShiftServiceImplTest.java
 * TestCase for the ShiftServiceImpl.java
 * @author Mbuso Kotobe (218040385)
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShiftServiceImplTest {
    private Shift shift = null;

    @Autowired
    private IShiftService service;

    @BeforeEach
    void setUp()
    {
        Role employeeRole = RoleFactory.build("1", "Electric Technician", "Maintains electrical systems in the hospital");
        Employee jeff = EmployeeFactory.build("1", employeeRole, "Jeff", "Tones", "jeffT@example.com", "jeffT");
        Set<Employee> shiftEmployees = new HashSet<>();
        shiftEmployees.add(jeff);

        LocalTime shiftStartTime = LocalTime.parse("22:00:00", DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime shiftEndTime = LocalTime.parse("06:00:00", DateTimeFormatter.ISO_LOCAL_TIME);
        shift = ShiftFactory.build(1, shiftStartTime, shiftEndTime, "Night Shift", shiftEmployees);
    }

    @Order(1)
    @Test
    void save()
    {
        Shift result = null;

        result = service.save(shift);

        assertNotNull(result);
        assertEquals(shift, result);
    }

    @Order(2)
    @Test
    void read()
    {
        int shiftId = 1;
        Optional<Shift> result = null;

        result = service.read(shiftId);

        assertTrue(result.isPresent());
        assertEquals(shift, result.get());
    }

    @Order(3)
    @Test
    void findAll()
    {
        List<Shift> shifts = null;

        shifts = service.findAll();

        assertTrue(shifts.size() > 0);
    }

    @Order(4)
    @Test
    void deleteById()
    {
        int shiftId = 1;
        Optional<Shift> result = null;

        service.deleteById(shiftId);
        result = service.read(shift.getShiftId());

        assertFalse(result.isPresent());
    }

    @Order(5)
    @Test
    @Disabled
    void delete()
    {
        Optional<Shift> result = null;

        service.delete(shift);

        result = service.read(shift.getShiftId());
        assertFalse(result.isPresent());

    }
}
