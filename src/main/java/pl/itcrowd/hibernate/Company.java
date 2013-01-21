package pl.itcrowd.hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY")
public class Company {

    @OneToMany(mappedBy = "company", cascade = CascadeType.MERGE)
    private List<Department> departaments;

    @Id
    @SequenceGenerator(name = "COMPANY_ID_SEQUENCE", initialValue = 1, sequenceName = "COMPANY_ID_SEQUENCE")
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "COMPANY_ID_SEQUENCE")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Embedded

    private Address address;

    public List<Department> getDepartaments() {
        return departaments;
    }


    public void setDepartaments(List<Department> departaments) {
        this.departaments = departaments;
    }


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
}
