package za.ac.cput.hospital_manager.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

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
        shift = ShiftFactory.build(1, "Computer Science", "Information");
        baseUrl = "http://localhost:" + portNumber + "/" + "college-management-system/shift/";
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
