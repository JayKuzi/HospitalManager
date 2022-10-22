package za.ac.cput.hospital_manager.factory;

/*
author: Ameer Ismail
student nr: 218216033
factory: Ward Factory
Project 3 Ind Assignment
*/

import za.ac.cput.hospital_manager.domain.Ward;

public class WardFactory
{
    public static Ward build(String wardId, String wardName, String wardDescription, int wardSize)
    {
        Ward ward = new Ward.Builder()
                .setWardId(wardId)
                .setWardName(wardName)
                .setWardDescription(wardDescription)
                .setWardSize(wardSize)
                .build();
        return ward;
    }
}
