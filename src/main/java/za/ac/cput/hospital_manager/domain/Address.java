package za.ac.cput.hospital_manager.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
@Entity
public class Address implements Serializable{

    //@NotBlank(message = "AddressId is mandatory")
    @Id
    private String addressId;

    //@NotBlank(message = "Patient id is mandatory")
    //@Id
    private String patientId;

    //@NotBlank(message = "House Number is mandatory")
    private String houseNumber;

    //@NotBlank(message = "Street Name is mandatory")
    private String streetName;

    //@NotBlank(message = "Suburb is mandatory")
    private String suburb;

    //@NotBlank(message = "City Name is mandatory")
    private String city;

    //@NotBlank(message = "Postal Code is mandatory")
    private String postalCode;

    //@NotBlank(message = "Province Name is mandatory")
    private String province;


    protected Address(){ }

    private Address(Builder builder)
    {
        this.addressId = builder.addressId;
        this.patientId = builder.patientId;
        this.houseNumber = builder.houseNumber;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
        this.province = builder.province;

    }

    public String getAddressId() {
        return addressId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }
    public String getCity() {
        return city;
    }
    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", patientId=" + patientId +
                ", houseNumber='" + houseNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressId, address.addressId)&&
                patientId.equals(address.patientId) &&
                houseNumber.equals(address.houseNumber) &&
                streetName.equals(address.streetName) &&
                suburb.equals(address.suburb) &&
                city.equals(address.city) &&
                postalCode.equals(address.postalCode) &&
                province.equals(address.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, patientId,
                houseNumber, streetName, suburb,
                city, postalCode, province);
    }

    public static class Builder
    {
        private String addressId;
        private String patientId;
        private String houseNumber;
        private String streetName;
        private String suburb;
        private String city;
        private String postalCode;
        private String province;

        public Builder addressId(String addressId)
        {
            this.addressId = addressId;
            return this;
        }

        public Builder patientId(String patientId)
        {
            this.patientId = patientId;
            return this;
        }

        public Builder houseNumber(String houseNumber)
        {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder streetName(String streetName)
        {
            this.streetName = streetName;
            return this;
        }

        public Builder suburb(String suburb)
        {
            this.suburb = suburb;
            return this;
        }

        public Builder city(String city)
        {
            this.city = city;
            return this;
        }

        public Builder postalCode(String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }

        public Builder province(String province)
        {
            this.province = province;
            return this;
        }
        public Address build()
        {
            return new Address(this);
        }

    }
}
