package pl.itcrowd.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @SequenceGenerator(name = "EMPLOYEE_ID_SEQUENCE", initialValue = 1, sequenceName = "EMPLOYEE_ID_SEQUENCE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_ID_SEQUENCE")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private Address address;


    @ManyToOne(optional = true)
    private Employee boss;

    @JoinColumn(name = "department_id", nullable = false)
    @ManyToOne
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }


}
