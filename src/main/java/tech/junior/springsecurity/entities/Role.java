package tech.junior.springsecurity.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public enum Values {
        BASIC(1L),
        ADMIN(2L);

        long roleId;

        public long getRoleId() {
            return roleId;
        }

        Values(long roleId) {
            this.roleId = roleId;
        }
    }
}
