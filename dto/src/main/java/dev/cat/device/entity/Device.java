package dev.cat.device.entity;

import jakarta.persistence.*;

@NamedEntityGraph(
        name = "device-entity-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "manufacturer", subgraph = "address-subgraph")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "address-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("address")
                        }
                )
        }
)
@Entity
@Table(name = "device")
public class Device {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    @ManyToOne(fetch = FetchType.LAZY, cascade =
            {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    private String serialNumber;
    private int lotNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade =
            {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Device() {
    }

    public Device(Long id, String model, Manufacturer manufacturer, String serialNumber, int lotNumber, Supplier supplier) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.lotNumber = lotNumber;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
