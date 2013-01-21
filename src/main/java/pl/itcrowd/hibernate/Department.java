package pl.itcrowd.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "DEPATRMENT")
public class Department {
    @javax.persistence.Id
    @SequenceGenerator(name = "DEPARTMENT_ID_SEQUENCE", initialValue = 1, sequenceName = "DEPARTMENT_ID_SEQUENCE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT_ID_SEQUENCE")
    private Long Id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "address")
    private Address address;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Company company;


    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {

        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
