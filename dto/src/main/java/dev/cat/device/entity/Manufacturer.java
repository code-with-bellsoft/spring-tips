package dev.cat.device.entity;

import jakarta.persistence.*;

@Entity
@Table(name="manufacturer")
public class Manufacturer {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String license;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Manufacturer(Long id, String name, String license, Address address) {
        this.id = id;
        this.name = name;
        this.license = license;
        this.address = address;
    }

    public Manufacturer() {
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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
