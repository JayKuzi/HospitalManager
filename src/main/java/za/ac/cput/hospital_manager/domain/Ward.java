package za.ac.cput.hospital_manager.domain;

/*
author: Ameer Ismail
student nr: 218216033
Domain: ward domain
Project 3 Ind Assignment
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Ward implements Serializable
{
    @Id
    private String wardId;

    private String wardName, wardDescription;
    private int wardSize;

    protected Ward() {
    }

    private Ward(Builder builder) {
        this.wardId = builder.wardId;
        this.wardName = builder.wardName;
        this.wardDescription = builder.wardDescription;
        this.wardSize = builder.wardSize;
    }

    public String getWardId() {
        return wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public String getWardDescription() {
        return wardDescription;
    }

    public int getWardSize() {
        return wardSize;
    }

    @Override
    public boolean equals (Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ward ward = (Ward) o;
        return wardName.equals(ward.wardName) && wardDescription.equals(ward.wardDescription);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(wardId, wardName, wardDescription, wardSize);
    }


    @Override
    public String toString() {
        return "Ward{" +
                "wardId=" + wardId +
                ", wardName='" + wardName + '\'' +
                ", wardDescription='" + wardDescription + '\'' +
                ", wardSize=" + wardSize +
                '}';
    }

    public static class Builder
    {
        private int wardSize;
        private String wardId, wardName, wardDescription;


        public Builder setWardId(String wardId) {
            this.wardId = wardId;
            return this;
        }

        public Builder setWardName(String wardName) {
            this.wardName = wardName;
            return this;
        }

        public Builder setWardDescription(String wardDescription) {
            this.wardDescription = wardDescription;
            return this;
        }

        public Builder setWardSize(int wardSize) {
            this.wardSize = wardSize;
            return this;
        }

        public Builder copy(Ward ward) {
            this.wardId = ward.wardId;
            this.wardName = ward.wardName;
            this.wardDescription = ward.wardDescription;
            this.wardSize = ward.wardSize;
            return this;
        }

        public Ward build() {
            return new Ward(this);
        }
    }
}
