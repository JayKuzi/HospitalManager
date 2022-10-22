package za.ac.cput.hospital_manager.service.wardService.impl;


/*
author: Ameer Ismail
student nr: 218216033
Service impl: Ward service
Project 3 Ind Assignment
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospital_manager.domain.Ward;
import za.ac.cput.hospital_manager.repository.IWardRepository;
import za.ac.cput.hospital_manager.service.wardService.IWardService;

import java.util.List;
import java.util.Optional;

@Service
public class WardServiceImpl implements IWardService
{
    private final IWardRepository repo;

    @Autowired
    public WardServiceImpl(IWardRepository repo)
    {
        this.repo = repo;
    }

    //saving or creating a ward
    @Override
    public Ward save(Ward ward)
    {
        return this.repo.save(ward);
    }

    // reading a ward
    @Override
    public Optional<Ward> read(String id) {
        return this.repo.findById(id);
    }

    // deleting
    @Override
    public void delete(Ward ward)
    {
        this.repo.delete(ward);
    }

    //get all
    @Override
    public List<Ward> findAll()
    {
        return this.repo.findAll();
    }

    @Override
    public void deleteById(String id)
    {
        repo.deleteById(id);
    }
}
