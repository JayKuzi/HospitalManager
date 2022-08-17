package za.ac.cput.hospital_manager.service.roleService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospital_manager.domain.Role;
import za.ac.cput.hospital_manager.repository.IRoleRepository;
import za.ac.cput.hospital_manager.service.roleService.IRoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository repository;

    @Autowired public RoleServiceImpl(IRoleRepository repository){
        this.repository = repository;
    }

    @Override
    public Role save(Role role) {return  this.repository.save(role);}

    @Override
    public Optional<Role> read(String id){return this.repository.findById(id);}

    @Override
    public void delete (Role role){this.repository.delete(role);}

    @Override
    public List<Role> findAll(){return this. repository.findAll();}

    @Override
    public void deleteById(String id){
        this.repository.deleteById(id);
        Optional<Role> role = read(id);
        if (role.isPresent()){
            delete(role.get());
        }
    }

}
