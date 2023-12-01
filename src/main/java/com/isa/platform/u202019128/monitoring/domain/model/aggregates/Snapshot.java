package com.isa.platform.u202019128.monitoring.domain.model.aggregates;

import com.isa.platform.u202019128.inventory.domain.model.aggregates.Product;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Snapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String snapshotId;

    private String productSerialNumber;

    private Double temperature;

    // Obligatorio par AdvanceMonitoring
    private Double energy;

    private Integer leakage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public Snapshot() {

    }

    public Snapshot(String snapshotId, Double temperature, Product product) {
        this();
        this.snapshotId = snapshotId;
        this.temperature = temperature;
        this.product = product;
    }

    public Snapshot(String snapshotId, Double temperature, Double energy, Integer leakage, Product product) {
        this(snapshotId, temperature, product);
        this.energy = energy;
        this.leakage = leakage;
    }

}
