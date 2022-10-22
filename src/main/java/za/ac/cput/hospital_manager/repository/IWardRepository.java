package za.ac.cput.hospital_manager.repository;

/*
author: Ameer Ismail
student nr: 218216033
Repository: Ward repo
Project 3 Ind Assignment
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.hospital_manager.domain.Ward;

@Repository
public interface IWardRepository extends JpaRepository<Ward, Integer>
{

}
