package za.ac.cput.hospital_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.hospital_manager.domain.Role;
import za.ac.cput.hospital_manager.factory.RoleFactory;
import za.ac.cput.hospital_manager.service.roleService.IRoleService;

import java.util.List;

@RestController
@RequestMapping("hospital-manager/role/")
@Slf4j
public class RoleController {

    private final IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping("save")
    public ResponseEntity<Role> save(@RequestBody Role role){
        log.info("Save request: {}", role);
        Role validatedRole;
        try{
            validatedRole = RoleFactory.build(role.getRoleId(), role.getRoleName(), role.getRoleDescription());
        }catch (IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Role save = roleService.save(validatedRole);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Role> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Role role = this.roleService.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(role);
    }

    @GetMapping("read-all")
    public ResponseEntity<List<Role>> readAll(){
        List<Role> roleList = this.roleService.findAll();
        return ResponseEntity.ok(roleList);
    }
}
