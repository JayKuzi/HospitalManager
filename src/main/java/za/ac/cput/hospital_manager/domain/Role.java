package za.ac.cput.hospital_manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Role implements Serializable {

    @Id
    @Column(name="id")
    private String roleId;
    private String roleName, roleDescription;

    @OneToMany(mappedBy = "role")
    private List<Employee> employees;


    protected Role (){

    }

    private Role (Builder builder){
        this.roleId = builder.roleId;
        this.roleName = builder.roleName;
        this.roleDescription = builder.roleDescription;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId.equals(role.roleId) && roleName.equals(role.roleName) && roleDescription.equals(role.roleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleDescription);
    }

    public static class Builder{
        private String roleId, roleName, roleDescription;

        public Builder roleId(String roleId){
            this.roleId = roleId;
            return this;
        }

        public Builder roleName(String roleName){
            this.roleName = roleName;
            return this;
        }

        public Builder roleDescription(String roleDescription){
            this.roleDescription = roleDescription;
            return this;
        }

        public Role build(){
            return new Role(this);
        }
    }


}
