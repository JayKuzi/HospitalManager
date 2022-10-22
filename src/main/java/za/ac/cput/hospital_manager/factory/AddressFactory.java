package za.ac.cput.hospital_manager.factory;

import za.ac.cput.hospital_manager.helper.Helper;
import za.ac.cput.hospital_manager.domain.Address;


public class AddressFactory {
    public static Address createAddress(String addressId, String patientId,
                                        String houseNumber, String streetName,
                                        String suburb, String city, String postalCode,
                                        String province){
        Helper.checkStringParam("addressId", addressId);
        Helper.checkStringParam("patientId", patientId);
        Helper.checkStringParam("houseNumber", houseNumber);
        Helper.checkStringParam("streetName", streetName);
        Helper.checkStringParam("suburb", suburb);
        Helper.checkStringParam("city", city);
        Helper.checkStringParam("postalCode", postalCode);
        Helper.checkStringParam("province", province);

        return new Address.Builder().addressId(addressId).patientId(patientId).houseNumber(houseNumber)
                .streetName(streetName).suburb(suburb).city(city)
                .postalCode(postalCode).province(province).build();

    }

}
