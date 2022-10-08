package za.ac.cput.hospital_manager.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.hospital_manager.domain.Employee;
import za.ac.cput.hospital_manager.domain.Role;
import za.ac.cput.hospital_manager.domain.Shift;
import za.ac.cput.hospital_manager.factory.EmployeeFactory;
import za.ac.cput.hospital_manager.factory.RoleFactory;
import za.ac.cput.hospital_manager.factory.ShiftFactory;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/***
 * ShiftControllerTest.java
 * TestCase for the Shift Controller
 * @author Mbuso Kotobe (218040385)
 * Date: 21 August 2022
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShiftControllerTest {
    private Shift shift = null;
    private String baseUrl;

    @Autowired
    private ShiftController shiftController;

    @LocalServerPort
    private int portNumber;

    @Autowired
    private TestRestTemplate restTemplate;


    @BeforeEach
    void setUp()
    {
        Role employeeRole = RoleFactory.build("1", "Electric Technician", "Maintains electrical systems in the hospital");
        Employee jeff = EmployeeFactory.build("1", employeeRole, "Jeff", "Tones", "jeffT@example.com", "jeffT");
        Set<Employee> shiftEmployees = new HashSet<Employee>();
        shiftEmployees.add(jeff);

        LocalTime shiftStartTime = LocalTime.parse("08:00:00", DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime shiftEndTime = LocalTime.parse("16:00:00", DateTimeFormatter.ISO_LOCAL_TIME);
        shift = ShiftFactory.build(1, shiftStartTime, shiftEndTime, "Day Shift", shiftEmployees);
        baseUrl = "http://localhost:" + portNumber + "/" + "hospital-manager/shift/";
    }

    @Order(1)
    @Test
    void save()
    {
        String url = baseUrl.concat("save");
        ResponseEntity<Shift> response = null;

        response = restTemplate.postForEntity(url, shift, Shift.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(2)
    @Test
    void read()
    {
        int shiftId = 1;
        String url = baseUrl.concat("read/") + shiftId;
        ResponseEntity<Shift> response = null;

        response = restTemplate.getForEntity(url, Shift.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Order(3)
    @Test
    void findAll()
    {
        String url = baseUrl.concat("find-all");
        ResponseEntity<Shift[]> response = null;

        response = restTemplate.getForEntity(url, Shift[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length > 0);
    }

    @Order(4)
    @Test
    void deleteById()
    {
        int shiftId = 1;
        String url = baseUrl.concat("delete-by-id/") + shiftId;
        String readUrl = baseUrl.concat("read/") + shiftId;
        ResponseEntity<Shift> response = null;

        restTemplate.delete(url);
        response = restTemplate.getForEntity(readUrl, Shift.class);
        System.out.println(response);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Order(5)
    @Test
    @Disabled
    void delete()
    {
        String url = baseUrl.concat("delete");
        String readUrl = baseUrl.concat("read/") + shift.getShiftId();
        ResponseEntity<Shift> response = null;

        restTemplate.delete(url, shift, Shift.class);
        response = restTemplate.getForEntity(readUrl, Shift.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
