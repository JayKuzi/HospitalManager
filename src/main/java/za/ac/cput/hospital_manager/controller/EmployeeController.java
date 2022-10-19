package za.ac.cput.hospital_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.hospital_manager.domain.Employee;
import za.ac.cput.hospital_manager.domain.Role;
import za.ac.cput.hospital_manager.factory.EmployeeFactory;
import za.ac.cput.hospital_manager.factory.RoleFactory;
import za.ac.cput.hospital_manager.service.employeeService.IEmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hospital-manager/employee/")
@Slf4j
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        log.info("Save request: {}", employee);
        Role validatedRole;
        Employee validatedEmployee;
        try{
            validatedRole = RoleFactory.build(employee.getRole().getRoleId(),
                    employee.getRole().getRoleName(), employee.getRole().getRoleDescription());
            validatedEmployee = EmployeeFactory.build(employee.getEmployeeId(), validatedRole, employee.getName(),
                    employee.getSurname(), employee.getPassword());
        }catch(IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Employee save = employeeService.save(validatedEmployee);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Employee> read (@PathVariable String id){
        log.info("Read request: {}", id);
        Employee employee = this.employeeService.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("read-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Employee>> readAll(){
        List<Employee> employeeList = this.employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }
}
