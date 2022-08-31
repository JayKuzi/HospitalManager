package za.ac.cput.hospital_manager.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        LocalTime shiftStartTime = LocalTime.parse("08:00:00", DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime shiftEndTime = LocalTime.parse("16:00:00", DateTimeFormatter.ISO_LOCAL_TIME));
        shift = ShiftFactory.build("1", "Day Shift", shiftStartTime, shiftEndTime);
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
        long shiftId = 1;
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
        long shiftId = 1;
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
