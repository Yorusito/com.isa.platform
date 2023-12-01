package com.isa.platform.u202019128.inventory.domain.model.aggregates;

import com.isa.platform.u202019128.inventory.domain.model.valueObjects.EMonitoringLevel;
import com.isa.platform.u202019128.inventory.domain.model.valueObjects.SerialNumberRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Product extends AbstractAggregateRoot<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String brand;

    @NotBlank
    @NotNull
    private String model;

    @Embedded
    private final SerialNumberRecord serialNumber;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private EMonitoringLevel monitoringLevel;

    public Product() {
        this.serialNumber = new SerialNumberRecord();
    }

    public Product(String brand, String model, EMonitoringLevel monitoringLevel) {
        this();
        this.brand = brand;
        this.model = model;
        this.monitoringLevel = monitoringLevel;
    }

    // Getters

    public static EMonitoringLevel toRoleFromName(String name){
        return EMonitoringLevel.valueOf(name);
    }

    public String getMonitoringLevelName() {
        return monitoringLevel.name();
    }

    public String getSerialNumberString() {
        return serialNumber.serialNumber();
    }
    public SerialNumberRecord getSerialNumber() {
        return serialNumber;
    }

}
