package pl.itcrowd.hibernate;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class Start {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void PostConstruct() {


        Company company1 = new Company();
        Department department1 = new Department();
        Department department2 = new Department();
        Address address = new Address();
        Address address1 = new Address();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new  Employee();


        address.setCity("tarnow");
        address.setStreet("narutowicza");
        address.setZipcode("333");

        address1.setCity("Warsaw");
        address1.setStreet("klonowa");
        address1.setZipcode("555");

        company1.setName("comapny1");
        company1.setAddress(address);

        department1.setName("department1");
        department2.setName("department2");
        department1.setAddress(address);
        department2.setAddress(address);
        department1.setCompany(company1);
        department2.setCompany(company1);

        employee1.setAddress(address);
        employee1.setDepartment(department1);
        employee1.setName("kowalski");
        employee1.setBoss(employee2);

        employee2.setAddress(address);
        employee2.setDepartment(department2);
        employee2.setName("nowak");


        employee3.setAddress(address);
        employee3.setDepartment(department1);
        employee3.setName("kowal");
        employee3.setBoss(employee2);

        entityManager.persist(company1);
        entityManager.persist(department1);
        entityManager.persist(department2);

        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
    }
}
